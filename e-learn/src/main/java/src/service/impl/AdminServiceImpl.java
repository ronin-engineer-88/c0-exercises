package src.service.impl;

import src.dto.request.user.UserLoginReq;
import src.dto.response.admin.*;
import src.entity.Teacher;
import src.service.IAdminService;

public class AdminServiceImpl implements IAdminService {
    @Override
    public Object login(UserLoginReq req) {
        return req;
    }

    @Override
    public UserInfoRes getUserInfo(Long userId) {
        UserInfoRes res = new UserInfoRes();
        res.setUserId(userId);

        return res;
    }

    public UserCourseInfoRes getUserCourseInfo(Long userId, Long courseId) {
        UserCourseInfoRes res = new UserCourseInfoRes();
        res.setUserId(userId);
        res.setCourseId(courseId);

        return res;
    }

    @Override
    public UserCourseLessonInfoRes getUserCourseLessonInfo(Long userId, Long courseId, Long lessonId) {
        UserCourseLessonInfoRes res = new UserCourseLessonInfoRes();
        res.setUserId(userId);
        res.setCourseId(courseId);
        res.setLessonId(lessonId);

        return res;
    }

    @Override
    public TeacherInfoRes getTeacherInfo(Long teacherId) {
        TeacherInfoRes res = new TeacherInfoRes();
        res.setTeacherId(teacherId);

        return res;
    }

    @Override
    public CourseInfoRes getCourseInfo(Long courseId) {
        CourseInfoRes res = new CourseInfoRes();
        res.setCourseId(courseId);

        return res;
    }

    @Override
    public ChapterInfoRes getChapterInfo(Long chapterId) {
        ChapterInfoRes res = new ChapterInfoRes();
        res.setChapterId(chapterId);

        return res;
    }

    @Override
    public Object getLessonInfo(Long lessonId) {
        LessonInfoRes res = new LessonInfoRes();
        res.setLessonId(lessonId);

        return res;
    }


}
