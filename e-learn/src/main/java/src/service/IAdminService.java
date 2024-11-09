package src.service;

import src.dto.request.user.UserLoginReq;

public interface IAdminService {
    Object login(UserLoginReq req);
    Object getUserInfo(Long userId);
    Object getUserCourseInfo(Long userId, Long courseId);
    Object getUserCourseLessonInfo(Long userId, Long courseId, Long lessonId);
    Object getTeacherInfo(Long teacherId);
    Object getCourseInfo(Long courseId);
    Object getChapterInfo(Long chapterId);
    Object getLessonInfo(Long lessonInfo);
    void deleteByStatus(String value);
}
