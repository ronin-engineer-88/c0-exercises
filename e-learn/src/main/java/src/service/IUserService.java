package src.service;

import src.dto.request.user.*;
import src.entity.Course;
import src.entity.StudentCourse;

import java.util.List;

public interface IUserService {
    Object register(UserRegisterReq req);
    Object login(UserLoginReq req);
    Object updateUser(Long userId, UserUpdateReq req);
    void deleteUser(Long userId);
    Object getUsers(Integer page, Integer pageSize, String sort, UserSearchReq req);
    Object enrollCourse(Long userId, Long courseId);
    Object rateCourse(Long userId, Long courseId, UserRateCourseReq req);
    Object reviewCourse(Long userId, Long courseId, UserReviewCourseReq req);
    Object getCourseInfo(Long courseId);
    Object getRegisterCourse(Long userId, UserSearchCourseReq req, Integer page, Integer pageSize, String sort);
    Object study(Long userId, Long courseId, Long lessonId, UserStudyReq req);
}
