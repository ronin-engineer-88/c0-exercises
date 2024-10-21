package src.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import src.constant.ConfigConstant;
import src.constant.StatusConstant;
import src.dto.request.user.*;
import src.dto.response.admin.UserSearchRes;
import src.dto.response.user.*;
import src.entity.Course;
import src.entity.Student;
import src.entity.StudentCourse;
import src.exception.*;
import src.repository.CourseRepository;
import src.repository.StudentCourseRepository;
import src.repository.StudentRepository;
import src.service.IUserService;
import src.service.validator.UserValidateService;
import src.util.DateUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(IUserService.class);

    @Autowired
    private UserValidateService userValidateService;

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public UserResponseDto register(UserRegisterReq req) {

        if(Objects.nonNull(studentRepository.findStudentByUsername(req.getUsername())))
            throw new UsernameExistException("Username is already existed!");

        Student student = new Student();
        BeanUtils.copyProperties(req, student);
        student.setCreatedDate(LocalDateTime.now());
        student.setStatus(ConfigConstant.ACTIVE.getValue());

        Student savedStudent = studentRepository.save(student);

        UserResponseDto res = new UserResponseDto();
        BeanUtils.copyProperties(savedStudent, res);
        res.setCreatedDate(DateUtils.dateTimeToString(savedStudent.getCreatedDate()));

        return res;
    }

    @Override
    public UserResponseDto login(UserLoginReq req) {

        Student student = studentRepository.findStudentByUsername(req.getUsername());
        if(Objects.isNull(student))
            throw new UserNotFoundException("Incorrect username!");

        if(!req.getPassword().equals(student.getPassword()))
            throw new InvalidPasswordException("Incorrect password!");

        UserResponseDto res = new UserResponseDto();
        BeanUtils.copyProperties(student, res);

        return res;
    }

    @Override
    public UserResponseDto updateUser(Long userId, UserUpdateReq req) {

        userValidateService.validateStatusRequest(req.getStatus());
        Student student = studentRepository.getStudentById(userId);
        if(Objects.isNull(student))
            throw new UserNotFoundException("Not found student with id: " + userId);

        BeanUtils.copyProperties(req, student);
        student.setUpdatedDate(LocalDateTime.now());

        Student savedStudent = studentRepository.save(student);

        UserResponseDto res = new UserResponseDto();
        BeanUtils.copyProperties(savedStudent, res);
        res.setUpdatedDate(DateUtils.dateTimeToString(savedStudent.getUpdatedDate()));

        return res;
    }

    @Override
    public void deleteUser(Long userId) {

        Student student = studentRepository.getStudentById(userId);
        if(Objects.isNull(student))
            throw new UserNotFoundException("Not found student with id: " + userId);

        student.setStatus(ConfigConstant.INACTIVE.getValue());
        student.setUpdatedDate(LocalDateTime.now());
        studentRepository.save(student);

        log.info("Soft delete student with id: {}", userId);
    }

    @Override
    public UserSearchRes getUsers(Integer page, Integer pageSize, String sort, UserSearchReq req) {

        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(sort));

        Page<Student> studentPage = studentRepository.findStudents(
                req.getName(),
                req.getAge(),
                req.getUsername(),
                req.getStatus(),
                req.getCreatedDateFrom(),
                req.getCreatedDateTo(),
                pageRequest
        );

        List<Student> students = studentPage.getContent();
        List<UserResponseDto> listStudentRes = students.stream().map(student -> {
            UserResponseDto studentRes = new UserResponseDto();
            BeanUtils.copyProperties(student, studentRes);
            return studentRes;
        })
                .collect(Collectors.toList());

        UserSearchRes res = new UserSearchRes();
        res.setStudents(listStudentRes);
        res.setTotalElements(studentPage.getTotalElements());
        res.setTotalPage(studentPage.getTotalPages());
        res.setPage(page);
        res.setPageSize(pageSize);

        return res;
    }

    @Override
    public UserEnrollCourseRes enrollCourse(Long userId, Long courseId) {

        UserEnrollCourseRes res = new UserEnrollCourseRes();
        res.setUserId(userId);
        res.setCourseID(courseId);

        return res;
    }

    @Override
    public UserRateCourseRes rateCourse(Long userId, Long courseId, Integer rate) {

        UserRateCourseRes res = new UserRateCourseRes();
        res.setUserId(userId);
        res.setCourseID(courseId);
        res.setRate(rate);

        return res;
    }

    @Override
    public UserReviewCourseRes reviewCourse(Long userId, Long courseId, String review) {

        UserReviewCourseRes res = new UserReviewCourseRes();
        res.setUserId(userId);
        res.setCourseId(courseId);
        res.setReview(review);

        return res;
    }

    @Override
    public Object getCourseInfo(Long courseId) {
        return courseId;
    }

    @Override
    public UserSearchCourseRes getRegisterCourse(Long userId, UserSearchCourseReq req, Integer page, Integer pageSize, String sort) {
        UserSearchCourseRes res = new UserSearchCourseRes();
        res.setUserId(userId);
        res.setName(req.getName());
        res.setFromDate(req.getFromDate());
        res.setToDate(req.getToDate());
        res.setTeacher(req.getTeacher());
        res.setStatus(req.getStatus());
        res.setNumLessons(req.getNumLessons());
        res.setPageSize(pageSize);
        res.setPage(page);
        res.setSort(sort);

        return res;
    }

    @Override
    public UserStudyRes study(Long userId, Long courseId, String status) {
        UserStudyRes res = new UserStudyRes();
        res.setUserId(userId);
        res.setCourseId(courseId);
        res.setStatus(status);

        return res;
    }


}
