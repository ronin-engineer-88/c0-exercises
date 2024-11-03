package src.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import src.constant.ConfigConstant;
import src.dto.request.admin.TeacherCreateReq;
import src.dto.request.admin.TeacherSearchReq;
import src.dto.request.admin.TeacherUpdateReq;
import src.dto.response.admin.TeacherResDto;
import src.dto.response.admin.TeacherSearchRes;
import src.entity.Teacher;
import src.exception.AppException;
import src.repository.TeacherRepository;
import src.service.ITeacherService;
import src.untils.DateUtils;
import src.untils.PageableUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements ITeacherService {

    private static final Logger log = LoggerFactory.getLogger(ITeacherService.class);

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public TeacherResDto createTeacher(TeacherCreateReq req) {
        if (teacherRepository.existsByUsername(req.getUsername())) {
            throw new AppException("username already exists");
        }

        Teacher teacher =  Teacher.builder()
                .name(req.getName())
                .username(req.getUsername())
                .password(req.getPassword())
                .status(ConfigConstant.ACTIVE.getValue())
                .build();
        teacher.setCreatedDate(new Date());
        teacherRepository.save(teacher);

        TeacherResDto res = new TeacherResDto();
        BeanUtils.copyProperties(teacher, res);

        return res;
    }

    @Override
    public TeacherResDto updateTeacher(Long teacherId, TeacherUpdateReq req) {
        if (req.getStatus() != null && (ConfigConstant.INACTIVE.getCode() != req.getStatus()
                                    && ConfigConstant.ACTIVE.getCode() != req.getStatus())) {
            throw new AppException("Status must be 0 (inactive) or 1 (active)");
        }

        Teacher teacher = teacherRepository.getTeacherById(teacherId);
        if (Objects.isNull(teacher)) {
            throw new AppException("Teacher not found with id: " + teacherId);
        }

        if (!teacher.getUsername().equals(req.getUsername())
                && teacherRepository.existsByUsername(req.getUsername())) {
            throw new AppException("Username already exists");
        }

        if (req.getStatus() != null) {
            String newStatus = (req.getStatus() == ConfigConstant.INACTIVE.getCode())
                    ? ConfigConstant.INACTIVE.getValue()
                    : ConfigConstant.ACTIVE.getValue();

            if (!newStatus.equals(teacher.getStatus())) teacher.setStatus(newStatus);
        }
        Optional.ofNullable(req.getName()).ifPresent(teacher::setName);
        Optional.ofNullable(req.getUsername()).ifPresent(teacher::setUsername);
        Optional.ofNullable(req.getPassword()).ifPresent(teacher::setPassword);

        teacher.setUpdatedDate(new Date());

        teacherRepository.save(teacher);

        TeacherResDto res = new TeacherResDto();
        BeanUtils.copyProperties(teacher, res);

        return res;
    }

    @Override
    public void deleteTeacher(Long teacherId) {
        Teacher teacher = teacherRepository.getTeacherById(teacherId);
        if (Objects.isNull(teacher)) {
            throw new AppException("Teacher not found with id: " + teacherId);
        }

        teacher.setStatus(ConfigConstant.INACTIVE.getValue());
        teacher.setUpdatedDate(new Date());
        teacherRepository.save(teacher);

        log.info("Soft delete teacher with id: {}", teacherId);
    }

    @Override
    public TeacherSearchRes getTeachers(TeacherSearchReq req) {
        req.setPageIndex(req.getPageIndex() != null && req.getPageIndex() >= 0 ? req.getPageIndex() : 0);
        req.setPageSize(req.getPageSize() != null && req.getPageSize() >= 1 ? req.getPageSize() : 10);
        //
        Sort sort = PageableUtils.determineSort(req.getSort());
        Pageable pageable = PageRequest.of(req.getPageIndex(), req.getPageSize(), sort);

        Page<Teacher> teacherPage = teacherRepository.findTeachers(
                req.getUsername(),
                req.getName(),
                req.getStatus(),
                DateUtils.stringToDate(req.getCreatedDateFrom()),
                DateUtils.stringToDate(req.getCreatedDateTo()),
                pageable
        );

        List<TeacherResDto> listTeachers = teacherPage.getContent().stream()
                .map(teacher -> {
                    TeacherResDto teacherResDto = new TeacherResDto();
                    BeanUtils.copyProperties(teacher, teacherResDto);
                    return teacherResDto;
                }).collect(Collectors.toList());

        TeacherSearchRes res = new TeacherSearchRes();
        res.setTeachers(listTeachers);
        res.setTotalItems(teacherPage.getTotalElements());

        return res;
    }
}
