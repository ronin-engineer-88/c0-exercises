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
import src.dto.response.user.CourseDetailResponse.CourseDetailDto;
import src.entity.*;
import src.entity.CompositeKey.StudentCourseId;
import src.entity.CompositeKey.StudentCourseLessonId;
import src.repository.UserCourseRepository;
import src.repository.UserRepository;
import src.repository.UserCourseLessonRepository;
import src.service.IUserService;
import src.service.validator.*;
import src.util.CourseUtils;
import src.util.DateUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(IUserService.class);
    private final UserRepository userRepository;
    private final UserCourseRepository userCourseRepository;
    private final UserCourseLessonRepository userCourseLessonRepository;
    private final UserValidateService userValidateService;
    private final CourseValidateService courseValidateService;
    private final LessonValidatorService lessonValidatorService;
    private final UserCourseValidateService userCourseValidateService;
    private final UserCourseLessonValidateService userCourseLessonValidateService;
    private final RequestValidateService requestValidateService;

    @Autowired
    public UserServiceImpl(
            UserRepository userRepository,
            UserCourseRepository userCourseRepository,
            UserCourseLessonRepository userCourseLessonRepository,
            UserValidateService userValidateService,
            CourseValidateService courseValidateService,
            LessonValidatorService lessonValidatorService,
            UserCourseValidateService userCourseValidateService,
            UserCourseLessonValidateService userCourseLessonValidateService,
            RequestValidateService requestValidateService

    ) {
        this.userRepository = userRepository;
        this.userCourseRepository = userCourseRepository;
        this.userCourseLessonRepository = userCourseLessonRepository;
        this.userValidateService = userValidateService;
        this.courseValidateService = courseValidateService;
        this.lessonValidatorService = lessonValidatorService;
        this.userCourseValidateService = userCourseValidateService;
        this.userCourseLessonValidateService = userCourseLessonValidateService;
        this.requestValidateService = requestValidateService;
    }


    @Override
    public UserResponseDto register(UserRegisterReq req) {

        userValidateService.checkRegisterUsername(req.getUsername());

        Student user = new Student();
        BeanUtils.copyProperties(req, user);
        user.setCreatedDate(LocalDateTime.now());
        user.setStatus(ConfigConstant.ACTIVE.getValue());

        Student savedStudent = userRepository.save(user);

        UserResponseDto res = new UserResponseDto();
        BeanUtils.copyProperties(savedStudent, res);
        res.setCreatedDate(DateUtils.dateTimeToString(savedStudent.getCreatedDate()));

        return res;
    }

    @Override
    public UserResponseDto login(UserLoginReq req) {

        Student user = userValidateService.validateLoginUsername(req.getUsername());

        userValidateService.checkLoginPassword(user, req.getPassword());

        UserResponseDto res = new UserResponseDto();
        BeanUtils.copyProperties(user, res);

        return res;
    }

    @Override
    public UserResponseDto updateUser(Long userId, UserUpdateReq req) {

        Student user = userValidateService.validateUserExist(userId);
        requestValidateService.checkConfigStatusRequest(req.getStatus());

        BeanUtils.copyProperties(req, user);
        user.setUpdatedDate(LocalDateTime.now());
        String newStatus = (req.getStatus() == ConfigConstant.INACTIVE.getCode())
                            ? ConfigConstant.INACTIVE.getValue() : ConfigConstant.ACTIVE.getValue();
        if(!newStatus.equals(user.getStatus()))
            user.setStatus(newStatus);

        Student savedStudent = userRepository.save(user);

        UserResponseDto res = new UserResponseDto();
        BeanUtils.copyProperties(savedStudent, res);
        res.setUpdatedDate(DateUtils.dateTimeToString(savedStudent.getUpdatedDate()));

        return res;
    }

    @Override
    public void deleteUser(Long userId) {

        Student user = userValidateService.validateUserExist(userId);
        userValidateService.checkActiveUser(user);

        user.setStatus(ConfigConstant.INACTIVE.getValue());
        user.setUpdatedDate(LocalDateTime.now());
        userRepository.save(user);

        log.info("Soft delete user with id: {}", userId);
    }

    @Override
    public UserSearchRes getUsers(Integer page, Integer pageSize, String sort, UserSearchReq req) {

        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(sort));

        Page<Student> studentPage = userRepository.findStudents(
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

        Student user = userValidateService.validateUserExist(userId);
        userValidateService.checkActiveUser(user);
        Course course = courseValidateService.validateCourseExist(courseId);
        courseValidateService.validateActiveCourse(course);
        userCourseValidateService.checkIfUserAlreadyEnrolledCourse(user, course);

        StudentCourseId studentCourseId = new StudentCourseId();
        studentCourseId.setStudentId(userId);
        studentCourseId.setCourseId(courseId);

        StudentCourse sc = new StudentCourse();
        sc.setStudentCourseId(studentCourseId);
        sc.setStudent(user);
        sc.setCourse(course);
        sc.setCreatedDate(LocalDateTime.now());
        sc.setStatus(StatusConstant.START.getValue());

        StudentCourse savedSc = userCourseRepository.save(sc);

        for(Chapter ch : savedSc.getCourse().getChapters()) {
            for(Lesson l : ch.getLessons()) {
                StudentCourseLesson scl = new StudentCourseLesson();
                StudentCourseLessonId id = new StudentCourseLessonId();
                id.setStudentCourseId(savedSc.getStudentCourseId());
                id.setLessonId(l.getId());
                scl.setId(id);
                scl.setStudentCourse(savedSc);
                scl.setLesson(l);
                scl.setStatus(StatusConstant.START.getValue());
                scl.setCreatedDate(LocalDateTime.now());
                userCourseLessonRepository.save(scl);
            }
        }

        UserEnrollCourseRes res = new UserEnrollCourseRes();
        BeanUtils.copyProperties(savedSc, res);
        res.setUserId(userId);
        res.setCourseId(courseId);
        res.setCreatedDate(DateUtils.dateTimeToString(savedSc.getCreatedDate()));

        log.info("User with id: {} has successfully enrolled in course with id: {}", userId, courseId);

        return res;
    }

    @Override
    public UserRateCourseRes rateCourse(Long userId, Long courseId, UserRateCourseReq req) {

        Student user = userValidateService.validateUserExist(userId);
        userValidateService.checkActiveUser(user);
        Course course = courseValidateService.validateCourseExist(courseId);
        courseValidateService.validateActiveCourse(course);
        StudentCourse sc = userCourseValidateService.validateUserEnrolledCourse(user, course);

        sc.setRating(req.getRate());
        sc.setUpdatedDate(LocalDateTime.now());

        StudentCourse savedSc = userCourseRepository.save(sc);

        UserRateCourseRes res = new UserRateCourseRes();
        res.setUserId(userId);
        res.setCourseId(courseId);
        res.setRate(req.getRate());
        res.setUpdatedDate(DateUtils.dateTimeToString(savedSc.getUpdatedDate()));

        log.info("User with id: {} has rated course with id: {}", userId, courseId);

        return res;
    }

    @Override
    public UserReviewCourseRes reviewCourse(Long userId, Long courseId, UserReviewCourseReq req) {

        Student user = userValidateService.validateUserExist(userId);
        userValidateService.checkActiveUser(user);
        Course course = courseValidateService.validateCourseExist(courseId);
        courseValidateService.validateActiveCourse(course);
        StudentCourse sc = userCourseValidateService.validateUserEnrolledCourse(user, course);

        sc.setReview(req.getReview());
        sc.setUpdatedDate(LocalDateTime.now());

        StudentCourse savedSc = userCourseRepository.save(sc);

        UserReviewCourseRes res = new UserReviewCourseRes();
        res.setUserId(userId);
        res.setCourseId(courseId);
        res.setReview(req.getReview());
        res.setUpdatedDate(DateUtils.dateTimeToString(savedSc.getUpdatedDate()));


        return res;
    }

    @Override
    public CourseDetailDto getCourseInfo(Long courseId) {

        Course course = courseValidateService.validateCourseExist(courseId);

        return CourseUtils.convertToDetailDto(course);
    }

    @Override
    public UserSearchCourseRes getRegisterCourse(Long userId, UserSearchCourseReq req, Integer page, Integer pageSize, String sort) {

        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(sort));

        Page<Course> coursePage = userRepository.findRegisterCourses(
                userId,
                req.getName(),
                req.getStatus(),
                req.getTeacherName(),
                req.getCreatedDateFrom(),
                req.getCreatedDateFrom(),
                req.getRatingFrom(),
                req.getRatingTo(),
                req.getNumLessons(),
                pageRequest
        );

        List<Course> courses = coursePage.getContent();
        List<CourseRegisterSearchResponse> listCourseRegisterRes = courses.stream().map(course -> {
            CourseRegisterSearchResponse courseRegisterRes = new CourseRegisterSearchResponse();
            BeanUtils.copyProperties(course, courseRegisterRes);
            for(StudentCourse sc : course.getStudentCourses()) {
                if(Objects.equals(sc.getStudent().getId(), userId))
                    courseRegisterRes.setRate(sc.getRating());
            }
            courseRegisterRes.setTeacherName(course.getTeacher().getName());
            courseRegisterRes.setNumChapters(course.getChapters().size());
            int numLessons = 0;
            for(Chapter ch : course.getChapters()) {
                numLessons += ch.getLessons().size();
            }
            courseRegisterRes.setNumLessons(numLessons);
            return courseRegisterRes;
        })
                .collect(Collectors.toList());

        UserSearchCourseRes res = new UserSearchCourseRes();
        res.setRegisterCourses(listCourseRegisterRes);
        res.setTotalElements(coursePage.getTotalElements());
        res.setTotalPage(coursePage.getTotalPages());
        res.setPage(page);
        res.setPageSize(pageSize);

        return res;
    }

    @Override
    public UserStudyRes study(Long userId, Long courseId, Long lessonId, UserStudyReq req) {

        Student user = userValidateService.validateUserExist(userId);
        userValidateService.checkActiveUser(user);
        Course course = courseValidateService.validateCourseExist(courseId);
        courseValidateService.validateActiveCourse(course);
        StudentCourse sc = userCourseValidateService.validateUserEnrolledCourse(user, course);
        Lesson lesson = lessonValidatorService.validateLessonExist(lessonId);
        lessonValidatorService.validateActiveLesson(lesson);
        StudentCourseLesson scl = userCourseLessonValidateService.validateCourseHasLesson(sc, lesson);

        scl.setStatus(req.getStatus());
        scl.setUpdatedDate(LocalDateTime.now());

        StudentCourseLesson savedScl = userCourseLessonRepository.save(scl);

        UserStudyRes res = new UserStudyRes();
        res.setUserId(userId);
        res.setCourseId(courseId);
        res.setLessonId(lessonId);
        res.setStatus(req.getStatus());
        res.setUpdatedDate(DateUtils.dateTimeToString(savedScl.getUpdatedDate()));

        return res;
    }


}
