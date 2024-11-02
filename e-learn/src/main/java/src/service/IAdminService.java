package src.service;

import src.dto.request.admin.AdminLoginReq;
import src.dto.request.user.UserLoginReq;
import src.entity.Admin;

public interface IAdminService {
    Object login(AdminLoginReq req);
    Object getUserInfo(Long userId);
    Object getUserCourseInfo(Long userId, Long courseId);
    Object getUserCourseLessonInfo(Long userId, Long courseId, Long lessonId);
    Object getTeacherInfo(Long teacherId);
    Object getCourseInfo(Long courseId);
    Object getChapterInfo(Long chapterId);
    Object getLessonInfo(Long lessonInfo);

}
