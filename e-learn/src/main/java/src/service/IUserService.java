package src.service;

import src.dto.request.user.UserInfoReq;
import src.dto.request.user.UserLoginReq;
import src.dto.request.user.UserSearchCourseReq;
import src.dto.request.user.UserSearchReq;

public interface IUserService {
    Object register(UserInfoReq req);
    Object login(UserLoginReq req);
    Object updateUser(Long userId, UserInfoReq req);
    Object deleteUser(Long userId);
    Object getUsers(Integer page, Integer pageSize, String sort, UserSearchReq req);
    Object enrollCourse(Long userId, Long courseId);
    Object rateCourse(Long userId, Long courseId, Integer rate);
    Object reviewCourse(Long userId, Long courseId, String review);
    Object getCourseInfo(Long courseId);
    Object getRegisterCourse(Long userId, UserSearchCourseReq req, Integer page, Integer pageSize, String sort);
    Object study(Long userId, Long courseId, String status);
}
