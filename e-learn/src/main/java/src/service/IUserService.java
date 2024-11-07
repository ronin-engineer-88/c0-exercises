package src.service;

import src.dto.request.user.*;
import src.dto.response.admin.UserSearchRes;
import src.dto.response.user.*;
import src.dto.response.user.DetailResponse.CourseResponseDto;
import src.dto.response.user.DetailResponse.UserResponseDto;

public interface IUserService {
    UserResponseDto register(UserRegisterReq req);
    UserResponseDto login(UserLoginReq req);
    UserResponseDto updateUser(Long userId, UserUpdateReq req);
    void deleteUser(Long userId);
    UserSearchRes getUsers(UserSearchReq req);
    UserEnrollCourseRes enrollCourse(Long userId, Long courseId);
    UserRateCourseRes rateCourse(Long userId, Long courseId, UserRateCourseReq req);
    UserReviewCourseRes reviewCourse(Long userId, Long courseId, UserReviewCourseReq req);
    CourseResponseDto getCourseInfo(Long courseId);
    UserSearchCourseRes getRegisterCourse(UserSearchCourseReq req);
    UserStudyRes study(Long userId, Long courseId, Long lessonId, UserStudyReq req);
}
