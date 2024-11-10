package src.service;

import src.dto.request.admin.AdminLoginReq;
import src.dto.request.user.UserLoginReq;
import src.dto.response.admin.*;
import src.entity.Admin;

public interface IAdminService {
    AdminResponseDto login(AdminLoginReq req);
    UserResponseDto getUserInfo(Long userId);
    UserCourseInfoRes getUserCourseInfo(Long userId, Long courseId);
    UserCourseLessonInfoRes getUserCourseLessonInfo(Long userId, Long courseId, Long lessonId);
    TeacherInfoRes getTeacherInfo(Long teacherId);
    CourseInfoRes getCourseInfo(Long courseId);
    ChapterInfoRes getChapterInfo(Long chapterId);
    LessonInfoRes getLessonInfo(Long lessonInfo);
    void deleteByStatus(String value);

}
