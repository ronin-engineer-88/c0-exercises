package src.service.impl;

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

        return AdminUtils.convertToResponseDto(admin);
    }

    @Override
    public UserResponseDto getUserInfo(Long userId) {

        User user = userValidateService.validateUserExist(userId);

        return UserUtils.Admin.convertToUserResponseDto(user);
    }

    public UserCourseInfoRes getUserCourseInfo(Long userId, Long courseId) {

        User user = userValidateService.validateUserExist(userId);
        Course course = courseValidateService.validateCourseExist(courseId);
        UserCourse sc = userCourseValidateService.validateUserEnrolledCourse(user, course);
        List<UserCourseLesson> userCourseLessonList = userCourseLessonRepository.getListUserCourseLesson(sc);

        UserCourseInfoRes res = new UserCourseInfoRes();
        res.setUser(UserUtils.Admin.convertToUserResponseDto(user));
        res.setCourse(CourseUtils.Admin.convertToCourseResponseDto(course));
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
        res.setNumLessonProcessing((int) userCourseLessonList.stream()
                .filter(scl -> StatusConstant.PROCESSING.getValue().equals(scl.getStatus()))
                .count());
        res.setNumLessonDone((int) userCourseLessonList.stream()
                .filter(scl -> StatusConstant.DONE.getValue().equals(scl.getStatus()))
                .count());

        return res;
    }

    @Override
    public UserCourseLessonInfoRes getUserCourseLessonInfo(Long userId, Long courseId, Long lessonId) {

        User user = userValidateService.validateUserExist(userId);
        Course course = courseValidateService.validateCourseExist(courseId);
        UserCourse sc = userCourseValidateService.validateUserEnrolledCourse(user, course);
        Lesson lesson = lessonValidatorService.validateLessonExist(lessonId);
        UserCourseLesson scl = userCourseLessonValidateService.validateCourseHasLesson(sc, lesson);

        UserCourseLessonInfoRes res = new UserCourseLessonInfoRes();
        res.setUser(UserUtils.Admin.convertToUserResponseDto(user));
        res.setCourse(CourseUtils.Admin.convertToCourseResponseDto(course));
        res.setLesson(LessonUtils.Admin.convertToLessonResponseDto(lesson));
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
        res.setTeacher(TeacherUtils.Admin.convertToResponseDto(teacher));
        res.setNumCourseTeach(teacher.getCourses().size());

        return res;
    }

    @Override
    public CourseInfoRes getCourseInfo(Long courseId) {

        Course course = courseValidateService.validateCourseExist(courseId);

        CourseInfoRes res = new CourseInfoRes();
        res.setCourse(CourseUtils.Admin.convertToCourseResponseDto(course));
        res.setNumChapter(course.getChapters().size());
        res.setNumLesson(course.getChapters().stream()
                .mapToInt(ch -> ch.getLessons().size())
                .sum());
        res.setNumRegisterUser(course.getUserCourses().size());

        return res;
    }

    @Override
    public ChapterInfoRes getChapterInfo(Long chapterId) {

        Chapter chapter = chapterValidateService.validateChapterExist(chapterId);

        ChapterInfoRes res = new ChapterInfoRes();
        res.setChapter(ChapterUtils.Admin.convertToResponseDto(chapter));
        res.setCourse(CourseUtils.Admin.convertToCourseResponseDto(chapter.getCourse()));
        res.setNumLesson(chapter.getLessons().size());

        return res;
    }

    @Override
    public LessonInfoRes getLessonInfo(Long lessonId) {

        Lesson lesson = lessonValidatorService.validateLessonExist(lessonId);

        LessonInfoRes res = new LessonInfoRes();
        res.setCourse(CourseUtils.Admin.convertToCourseResponseDto(lesson.getChapter().getCourse()));
        res.setChapter(ChapterUtils.Admin.convertToResponseDto(lesson.getChapter()));
        res.setLesson(LessonUtils.Admin.convertToLessonResponseDto(lesson));

        res.setNumUserProcessing((int) lesson.getUserCourseLessons().stream()
                .filter(scl -> StatusConstant.PROCESSING.getValue().equals(scl.getStatus()))
                .count()
        );
        res.setNumUserDone((int) lesson.getUserCourseLessons().stream()
                .filter(scl -> StatusConstant.DONE.getValue().equals(scl.getStatus()))
                .count()
        );

        return res;
    }


}
