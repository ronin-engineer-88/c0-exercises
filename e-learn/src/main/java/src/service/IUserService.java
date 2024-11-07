package src.service;

import src.dto.request.user.*;
import src.dto.response.admin.UserSearchRes;
import src.dto.response.user.DetailResponse.UserResponseDto;
import src.dto.response.user.UserEnrollCourseRes;
import src.dto.response.user.UserRateCourseRes;

public interface IUserService {
    UserResponseDto register(UserRegisterReq req);
    UserResponseDto login(UserLoginReq req);
    UserResponseDto updateUser(Long userId, UserUpdateReq req);
    void deleteUser(Long userId);
    UserSearchRes getUsers(UserSearchReq req);
    UserEnrollCourseRes enrollCourse(Long userId, Long courseId);
    UserRateCourseRes rateCourse(Long userId, Long courseId, UserRateCourseReq req);
    Object reviewCourse(Long userId, Long courseId, UserReviewCourseReq req);
    Object getCourseInfo(Long courseId);
    Object getRegisterCourse(UserSearchCourseReq req);
    Object study(Long userId, Long courseId, Long lessonId, UserStudyReq req);
}
