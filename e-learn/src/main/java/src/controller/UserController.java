package src.controller;

import org.springframework.web.bind.annotation.*;
import src.constant.UrlConstant;
import src.dto.request.*;
import src.dto.response.*;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController {

// User Đăng ký
    @PostMapping(UrlConstant.USER_REGISTER)
    public Object register(@RequestBody UserInfoReq req) {
        return req;
    }


// User Đăng nhập
    @PostMapping(UrlConstant.LOGIN)
    public Object login(@RequestBody UserLoginReq req) {
        return req;
    }


// User Cập nhật thông tin
    @PutMapping("{user_id}")
    public Object userUpdate(@PathVariable("user_id") int userId,
                             @RequestBody UserInfoReq req) {
        UserUpdateRes res = new UserUpdateRes();
        res.setId(userId);
        res.setUsername(req.getUsername());
        res.setPassword(req.getPassword());
        res.setName(req.getName());
        res.setStatus(req.getStatus());
        res.setCreatedDate(req.getCreatedDate());
        res.setUpdatedDate(req.getUpdatedDate());

        return res;
    }


// User Xóa tài khoản (soft delete)
    @DeleteMapping("{user_id}")
    public Object remove(@PathVariable("user_id") int userId) {
        return userId;
    }


// User Đăng ký khóa học
    @PostMapping("{user_id}" + UrlConstant.USER_ENROLL_COURSE)
    public Object enroll(@PathVariable("user_id") int userId,
                         @PathVariable("course_id") int courseId) {

        UserEnrollCourseRes res = new UserEnrollCourseRes();
        res.setUserId(userId);
        res.setCourseID(courseId);

        return res;
    }


// User Đánh giá khóa học
    @PostMapping("{user_id}" + UrlConstant.USER_RATE_COURSE)
    public Object rateCourse(@PathVariable("user_id") int userId,
                             @PathVariable("course_id") int courseId,
                             @RequestBody int rate) {

        UserRateCourseRes res = new UserRateCourseRes();

        res.setUserId(userId);
        res.setCourseID(courseId);
        res.setRate(rate);

        return res;
    }


// User Viết nhận xét
    @PostMapping("{user_id}" + UrlConstant.USER_REVIEW_COURSE)
    public Object commentCourse(@PathVariable("user_id") int userId,
                                @PathVariable("course_id") int courseId,
                                @RequestBody String review) {

        UserReviewCourseRes res = new UserReviewCourseRes();
        res.setUserId(userId);
        res.setCourseId(courseId);
        res.setReview(review);

        return res;
    }


// User xem chi tiết khóa học
    @GetMapping(UrlConstant.USER_VIEW_COURSE_INFO)
    public Object viewCourseInfo(@PathVariable("course_id") String courseId) {
        return courseId;
    }


/* User Xem danh sách & tìm kiếm khóa học mà user đăng ký
     - Không search gì => Hiển thị danh sách theo pagging và sorting
          + Mặc định là hiển thị 10 bản ghi mới nhất
          + Sort theo param mà client truyền vào (dạng mảng)
     - Có search:
          + Theo name
          + Theo ngày tháng (from, to)
          + Search theo giáo viên
          + Search theo rating (from, to) (Tính trung bình rating rồi tìm kiếm)
          + Search theo status
          + Search theo số lượng bài học của khóa
*/
    @GetMapping("{user_id}" + UrlConstant.USER_SEARCH_REGISTERED_COURSE)
    public Object searchRegisteredCourse(@PathVariable("user_id") int userId,
                                         @RequestBody UserSearchCourseReq req,
                                         @RequestParam int size,
                                         @RequestParam int page,
                                         @RequestParam String[] sort) {

        UserSearchCourseRes res = new UserSearchCourseRes();
        res.setUserId(userId);
        res.setName(req.getName());
        res.setFromDate(req.getFromDate());
        res.setToDate(req.getToDate());
        res.setTeacher(req.getTeacher());
        res.setStatus(req.getStatus());
        res.setNumLessons(req.getNumLessons());
        res.setSize(size);
        res.setPage(page);
        res.setSort(sort);

        return res;
    }


/* Học bài học:
    + Start bài học
    + Đang học
    + Kết thúc bài học
*/
    @PatchMapping("{user_id}" + UrlConstant.USER_STUDY)
    public Object study(@PathVariable("user_id") int userId,
                        @PathVariable("course_id") int courseId,
                        @RequestBody String status) {

        UserStudyRes res = new UserStudyRes();
        res.setUserId(userId);
        res.setCourseId(courseId);
        res.setStatus(status);

        return res;
    }

}