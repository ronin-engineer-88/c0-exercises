package src.service;

import src.dto.request.user.*;

public interface IUserService {
    Object register(UserRegisterReq req);
    Object login(UserLoginReq req);
    Object updateUser(Long userId, UserUpdateReq req);
    void deleteUser(Long userId);
    Object getUsers(Integer page, Integer pageSize, String sort, UserSearchReq req);
    Object enrollCourse(Long userId, Long courseId);
    Object rateCourse(Long userId, Long courseId, Integer rate);
    Object reviewCourse(Long userId, Long courseId, String review);
    Object getCourseInfo(Long courseId);
    Object getRegisterCourse(Long userId, UserSearchCourseReq req, Integer page, Integer pageSize, String sort);
    Object study(Long userId, Long courseId, String status);
}
