package src.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.constant.StatusConstant;
import src.dto.request.admin.AdminLoginReq;
import src.dto.response.admin.*;
import src.entity.*;
import src.repository.UserCourseLessonRepository;
import src.service.IAdminService;
import src.service.validator.*;
import src.util.*;

import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService {
    private final UserCourseLessonRepository userCourseLessonRepository;
    private final AdminValidateService adminValidateService;
    private final UserValidateService userValidateService;
    private final CourseValidateService courseValidateService;
    private final ChapterValidateService chapterValidateService;
    private final LessonValidatorService lessonValidatorService;
    private final TeacherValidateService teacherValidateService;
    private final UserCourseValidateService userCourseValidateService;
    private final UserCourseLessonValidateService userCourseLessonValidateService;
    private final RequestValidateService requestValidateService;


    @Autowired
    public AdminServiceImpl(
            UserCourseLessonRepository userCourseLessonRepository,
            AdminValidateService adminValidateService,
            UserValidateService userValidateService,
            CourseValidateService courseValidateService,
            ChapterValidateService chapterValidateService,
            LessonValidatorService lessonValidatorService,
            TeacherValidateService teacherValidateService,
            UserCourseValidateService userCourseValidateService,
            UserCourseLessonValidateService userCourseLessonValidateService,
            RequestValidateService requestValidateService
    ) {
        this.userCourseLessonRepository = userCourseLessonRepository;
        this.adminValidateService = adminValidateService;
        this.userValidateService = userValidateService;
        this.courseValidateService = courseValidateService;
        this.chapterValidateService = chapterValidateService;
        this.lessonValidatorService = lessonValidatorService;
        this.teacherValidateService = teacherValidateService;
        this.userCourseValidateService = userCourseValidateService;
        this.userCourseLessonValidateService = userCourseLessonValidateService;
        this.requestValidateService = requestValidateService;

    }

    @Override
    public AdminResponseDto login(AdminLoginReq req) {

        Admin admin = adminValidateService.validateLoginUsername(req.getUsername());
        requestValidateService.checkLoginPassword(admin, req.getPassword());

        AdminResponseDto res = new AdminResponseDto();
        BeanUtils.copyProperties(admin, res);
        res.setCreatedDate(DateUtils.dateTimeToString(admin.getCreatedDate()));
        res.setUpdatedDate(
                admin.getUpdatedDate() != null ? DateUtils.dateTimeToString(admin.getUpdatedDate()) : null
        );

        return res;
    }

    @Override
    public UserInfoRes getUserInfo(Long userId) {

        Student user = userValidateService.validateUserExist(userId);

        UserInfoRes res = new UserInfoRes();
        BeanUtils.copyProperties(user, res);
        res.setCreatedDate(DateUtils.dateTimeToString(user.getCreatedDate()));
        res.setUpdatedDate(
                user.getUpdatedDate() != null ? DateUtils.dateTimeToString(user.getUpdatedDate()) : null
        );
        res.setNumCourseRegister(user.getStudentCourses().size());

        return res;
    }

    public UserCourseInfoRes getUserCourseInfo(Long userId, Long courseId) {

        Student user = userValidateService.validateUserExist(userId);
        Course course = courseValidateService.validateCourseExist(courseId);
        StudentCourse sc = userCourseValidateService.validateUserEnrolledCourse(user, course);
        List<StudentCourseLesson> studentCourseLessonList = userCourseLessonRepository.getListScl(sc);

        UserCourseInfoRes res = new UserCourseInfoRes();
        UserResponseDto userResponseDto = UserUtils.convertToUserResponseDto(user);
        CourseResponseDto courseResponseDto = CourseUtils.convertToCourseResponseDto(course);
        res.setUser(userResponseDto);
        res.setCourse(courseResponseDto);
        res.setRate(
                sc.getRating() != null ? sc.getRating() : null
        );
        res.setReview(
                sc.getReview() != null ? sc.getReview() : null
        );
        res.setCreatedDate(DateUtils.dateTimeToString(sc.getCreatedDate()));
        res.setUpdatedDate(
                sc.getUpdatedDate() != null ? DateUtils.dateTimeToString(sc.getUpdatedDate()) : null
        );
        res.setNumLessonProcessing((int) studentCourseLessonList.stream()
                .filter(scl -> StatusConstant.PROCESSING.getValue().equals(scl.getStatus()))
                .count());
        res.setNumLessonDone((int) studentCourseLessonList.stream()
                .filter(scl -> StatusConstant.DONE.getValue().equals(scl.getStatus()))
                .count());

        return res;
    }

    @Override
    public UserCourseLessonInfoRes getUserCourseLessonInfo(Long userId, Long courseId, Long lessonId) {

        Student user = userValidateService.validateUserExist(userId);
        Course course = courseValidateService.validateCourseExist(courseId);
        StudentCourse sc = userCourseValidateService.validateUserEnrolledCourse(user, course);
        Lesson lesson = lessonValidatorService.validateLessonExist(lessonId);
        StudentCourseLesson scl = userCourseLessonValidateService.validateCourseHasLesson(sc, lesson);

        UserCourseLessonInfoRes res = new UserCourseLessonInfoRes();
        UserResponseDto userResponseDto = UserUtils.convertToUserResponseDto(user);
        CourseResponseDto courseResponseDto = CourseUtils.convertToCourseResponseDto(course);
        LessonResDto lessonResDto = LessonUtils.convertToLessonResponseDto(lesson);
        res.setUser(userResponseDto);
        res.setCourse(courseResponseDto);
        res.setLesson(lessonResDto);
        res.setStatus(scl.getStatus());
        res.setCreatedDate(DateUtils.dateTimeToString(scl.getCreatedDate()));
        res.setUpdatedDate(
                scl.getUpdatedDate() != null ? DateUtils.dateTimeToString(scl.getUpdatedDate()) : null
        );

        return res;
    }

    @Override
    public TeacherInfoRes getTeacherInfo(Long teacherId) {

        Teacher teacher = teacherValidateService.validateTeacherExist(teacherId);
        TeacherInfoRes res = new TeacherInfoRes();
        TeacherResDto teacherResDto = TeacherUtils.convertToResponseDto(teacher);
        res.setTeacher(teacherResDto);
        res.setNumCourseTeach(teacher.getCourses().size());

        return res;
    }

    @Override
    public CourseInfoRes getCourseInfo(Long courseId) {

        Course course = courseValidateService.validateCourseExist(courseId);

        CourseInfoRes res = new CourseInfoRes();
        CourseResponseDto courseResponseDto = CourseUtils.convertToCourseResponseDto(course);
        res.setCourse(courseResponseDto);
        res.setNumChapter(course.getChapters().size());
        res.setNumLesson(course.getChapters().stream()
                .mapToInt(ch -> ch.getLessons().size())
                .sum());
        res.setNumRegisterUser(course.getStudentCourses().size());

        return res;
    }

    @Override
    public ChapterInfoRes getChapterInfo(Long chapterId) {

        Chapter chapter = chapterValidateService.validateChapterExist(chapterId);

        ChapterInfoRes res = new ChapterInfoRes();
        ChapterResponseDto chapterResponseDto = ChapterUtils.convertToResponseDto(chapter);
        CourseResponseDto courseResponseDto = CourseUtils.convertToCourseResponseDto(chapter.getCourse());
        res.setChapter(chapterResponseDto);
        res.setCourse(courseResponseDto);
        res.setNumLesson(chapter.getLessons().size());

        return res;
    }

    @Override
    public LessonInfoRes getLessonInfo(Long lessonId) {

        Lesson lesson = lessonValidatorService.validateLessonExist(lessonId);

        LessonInfoRes res = new LessonInfoRes();
        LessonResDto lessonResDto = LessonUtils.convertToLessonResponseDto(lesson);
        ChapterResponseDto chapterResponseDto = ChapterUtils.convertToResponseDto(lesson.getChapter());
        CourseResponseDto courseResponseDto = CourseUtils.convertToCourseResponseDto(lesson.getChapter().getCourse());
        res.setCourse(courseResponseDto);
        res.setChapter(chapterResponseDto);
        res.setLesson(lessonResDto);

        res.setNumUserProcessing((int) lesson.getStudentCourseLessons().stream()
                .filter(scl -> StatusConstant.PROCESSING.getValue().equals(scl.getStatus()))
                .count()
        );
        res.setNumUserDone((int) lesson.getStudentCourseLessons().stream()
                .filter(scl -> StatusConstant.DONE.getValue().equals(scl.getStatus()))
                .count()
        );

        return res;
    }


}
