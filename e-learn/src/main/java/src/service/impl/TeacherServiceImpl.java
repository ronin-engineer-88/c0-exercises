package src.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import src.constant.ConfigConstant;
import src.dto.request.admin.TeacherCreateReq;
import src.dto.request.admin.TeacherSearchReq;
import src.dto.request.admin.TeacherUpdateReq;
import src.dto.response.admin.TeacherResDto;
import src.dto.response.admin.TeacherSearchRes;
import src.entity.Teacher;
import src.exception.TeacherNotFoundException;
import src.repository.TeacherRepository;
import src.service.ICourseService;
import src.service.ITeacherService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements ITeacherService {

    private static final Logger log = LoggerFactory.getLogger(ICourseService.class);

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public TeacherResDto createTeacher(TeacherCreateReq req) {
        if (teacherRepository.existsByUsername(req.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username already exists.");
        }

        Teacher teacher =  Teacher.builder()
                .name(req.getName())
                .username(req.getUsername())
                .password(req.getPassword())
                .status(ConfigConstant.ACTIVE.getValue())
                .build();
        teacher.setCreatedDate(LocalDateTime.now());
        teacherRepository.save(teacher);

        TeacherResDto res = new TeacherResDto();
        BeanUtils.copyProperties(teacher, res);

        return res;
    }

    @Override
    public TeacherResDto updateTeacher(Long teacherId, TeacherUpdateReq req) {
        Teacher teacher = teacherRepository.getTeacherById(teacherId);
        if (Objects.isNull(teacher)) {
            throw new TeacherNotFoundException("Teacher not found with id: " + teacherId);
        }

        if (!teacher.getUsername().equals(req.getUsername())
                && teacherRepository.existsByUsername(req.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists.");
        }

        BeanUtils.copyProperties(req, teacher, "status");
        teacher.setUpdatedDate(LocalDateTime.now());
        String newStatus = (req.getStatus() == ConfigConstant.INACTIVE.getCode())
                ? ConfigConstant.INACTIVE.getValue() : ConfigConstant.ACTIVE.getValue();
        if (!newStatus.equals(teacher.getStatus())) {
            teacher.setStatus(newStatus);
        }

        teacherRepository.save(teacher);

        TeacherResDto res = new TeacherResDto();
        BeanUtils.copyProperties(teacher, res);
        return res;
    }

    @Override
    public void deleteTeacher(Long teacherId) {
        Teacher teacher = teacherRepository.getTeacherById(teacherId);
        if (Objects.isNull(teacher)) {
            throw new TeacherNotFoundException("Teacher not found with id: " + teacherId);
        }

        teacher.setStatus(ConfigConstant.INACTIVE.getValue());
        teacher.setUpdatedDate(LocalDateTime.now());
        teacherRepository.save(teacher);

        log.info("Soft delete teacher with id: {}", teacherId);
    }

    @Override
    public TeacherSearchRes getTeachers(int page, int pageSize, String sort, TeacherSearchReq req) {
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(sort));

        Page<Teacher> teacherPage = teacherRepository.findTeachers(
                req.getUsername(),
                req.getName(),
                req.getStatus(),
                req.getCreatedDateFrom(),
                req.getCreatedDateTo(),
                pageRequest
        );

        List<Teacher> teachers = teacherPage.getContent();

        List<TeacherResDto> listTeachers = teachers.stream().map(teacher -> {
            TeacherResDto teacherResDto = new TeacherResDto();
            BeanUtils.copyProperties(teacher, teacherResDto);
            return teacherResDto;
        }).collect(Collectors.toList());

        TeacherSearchRes res = new TeacherSearchRes();
        res.setTeachers(listTeachers);
        res.setTotalElements(teacherPage.getTotalElements());
        res.setTotalPages(teacherPage.getTotalPages());
        res.setPage(page);
        res.setPageSize(pageSize);
        return res;
    }
}
