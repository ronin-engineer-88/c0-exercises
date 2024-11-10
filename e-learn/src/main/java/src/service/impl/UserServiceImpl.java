package src.service.impl;

import org.springframework.stereotype.Service;
import src.dto.request.user.UserInfoReq;
import src.dto.request.user.UserLoginReq;
import src.dto.request.user.UserSearchCourseReq;
import src.dto.request.user.UserSearchReq;
import src.dto.response.admin.UserSearchRes;
import src.dto.response.user.*;
import src.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public Object register(UserInfoReq req) {
        return req;
    }

    @Override
    public Object login(UserLoginReq req) {
        return req;
    }

    @Override
    public UserUpdateRes updateUser(Long userId, UserInfoReq req) {
        UserUpdateRes res = new UserUpdateRes();
        res.setId(userId);
        res.setUsername(req.getUsername());
        res.setPassword(req.getPassword());
        res.setName(req.getName());
        res.setStatus(req.getStatus());

        return res;
    }

    @Override
    public Object deleteUser(Long userId) {
        return userId;
    }

    @Override
    public UserSearchRes getUsers(Integer page, Integer pageSize, String sort, UserSearchReq req) {
        UserSearchRes res = new UserSearchRes();
        res.setSort(sort);
        res.setPage(page);
        res.setPageSize(pageSize);
        res.setUsername(req.getUsername());
        res.setName(req.getName());
        res.setStatus(req.getStatus());
        res.setCreatedDateFrom(req.getCreatedDateFrom());
        res.setCreatedDateTo(req.getCreatedDateTo());

        return res;
    }

    @Override
    public UserEnrollCourseRes enrollCourse(Long userId, Long courseId) {
        UserEnrollCourseRes res = new UserEnrollCourseRes();
        res.setUserId(userId);
        res.setCourseID(courseId);

        return res;
    }

    @Override
    public UserRateCourseRes rateCourse(Long userId, Long courseId, Integer rate) {
        UserRateCourseRes res = new UserRateCourseRes();

        res.setUserId(userId);
        res.setCourseID(courseId);
        res.setRate(rate);

        return res;
    }

    @Override
    public UserReviewCourseRes reviewCourse(Long userId, Long courseId, String review) {
        UserReviewCourseRes res = new UserReviewCourseRes();
        res.setUserId(userId);
        res.setCourseId(courseId);
        res.setReview(review);

        return res;
    }

    @Override
    public Object getCourseInfo(Long courseId) {
        return courseId;
    }

    @Override
    public UserSearchCourseRes getRegisterCourse(Long userId, UserSearchCourseReq req, Integer page, Integer pageSize, String sort) {
        UserSearchCourseRes res = new UserSearchCourseRes();
        res.setUserId(userId);
        res.setName(req.getName());
        res.setFromDate(req.getFromDate());
        res.setToDate(req.getToDate());
        res.setTeacher(req.getTeacher());
        res.setStatus(req.getStatus());
        res.setNumLessons(req.getNumLessons());
        res.setPageSize(pageSize);
        res.setPage(page);
        res.setSort(sort);

        return res;
    }

    @Override
    public UserStudyRes study(Long userId, Long courseId, String status) {
        UserStudyRes res = new UserStudyRes();
        res.setUserId(userId);
        res.setCourseId(courseId);
        res.setStatus(status);

        return res;
    }
}
