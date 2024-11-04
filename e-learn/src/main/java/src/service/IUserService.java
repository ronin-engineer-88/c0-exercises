package src.service;

import src.dto.request.user.*;

public interface IUserService {
    Object register(UserRegisterReq req);
    Object login(UserLoginReq req);
    Object updateUser(Long userId, UserUpdateReq req);
    void deleteUser(Long userId);
    Object getUsers(UserSearchReq req);
    Object enrollCourse(Long userId, Long courseId);
    Object rateCourse(Long userId, Long courseId, UserRateCourseReq req);
    Object reviewCourse(Long userId, Long courseId, UserReviewCourseReq req);
    Object getCourseInfo(Long courseId);
    Object getRegisterCourse(UserSearchCourseReq req);
    Object study(Long userId, Long courseId, Long lessonId, UserStudyReq req);
}
