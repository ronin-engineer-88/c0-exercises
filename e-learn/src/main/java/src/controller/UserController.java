package src.controller;

import org.springframework.web.bind.annotation.*;
import src.constant.UrlConstant;
import src.dto.request.*;
import src.dto.response.*;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController {

    /**
     * User Đăng ký
     *
     * @param req Thông tin người dùng cần đăng ký
     * @return Thông tin người dùng đã đăng ký
     */
    @PostMapping(UrlConstant.USER_REGISTER)
    public Object register(@RequestBody UserInfoReq req) {
        return req;
    }


    /**
     * User Đăng nhập
     *
     * @param req Thông tin đăng nhập của người dùng
     * @return Thông tin đăng nhập người dùng
     */
    @PostMapping(UrlConstant.LOGIN)
    public Object login(@RequestBody UserLoginReq req) {
        return req;
    }


    /**
     * User Cập nhật thông tin
     *
     * @param userId ID của người dùng cần cập nhật
     * @param req Thông tin người dùng cần cập nhật
     * @return Thông tin người dùng sau khi cập nhật
     */
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


    /**
     * User Xóa tài khoản (soft delete)
     *
     * @param userId ID của người dùng cần xóa
     * @return ID của người dùng đã xóa
     */
    @DeleteMapping("{user_id}")
    public Object remove(@PathVariable("user_id") int userId) {
        return userId;
    }


    /**
     * User Đăng ký khóa học
     *
     * @param userId ID của người dùng đăng ký khóa học
     * @param courseId ID của khóa học cần đăng ký
     * @return Thông tin về việc đăng ký khóa học
     */
    @PostMapping("{user_id}" + UrlConstant.USER_ENROLL_COURSE)
    public Object enroll(@PathVariable("user_id") int userId,
                         @PathVariable("course_id") int courseId) {

        UserEnrollCourseRes res = new UserEnrollCourseRes();
        res.setUserId(userId);
        res.setCourseID(courseId);

        return res;
    }


    /**
     * User Đánh giá khóa học
     *
     * @param userId ID của người dùng đánh giá khóa học
     * @param courseId ID của khóa học cần đánh giá
     * @param rate Điểm đánh giá của người dùng
     * @return Thông tin về đánh giá của người dùng
     */
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


    /**
     * User viết nhận xét
     *
     * @param userId ID của người dùng viết nhận xét
     * @param courseId ID của khóa học cần nhận xét
     * @param review Nội dung nhận xét
     * @return Thông tin về nhận xét của người dùng
     */
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


    /**
     * User xem chi tiết khóa học
     *
     * @param courseId ID của khóa học cần xem
     * @return Thông tin chi tiết của khóa học
     */
    @GetMapping(UrlConstant.USER_VIEW_COURSE_INFO)
    public Object viewCourseInfo(@PathVariable("course_id") String courseId) {
        return courseId;
    }


    /**
     * User Xem danh sách & tìm kiếm khóa học mà user đăng ký
     * - Không search gì => Hiển thị danh sách theo pagging và sorting
     *   + Mặc định là hiển thị 10 bản ghi mới nhất
     *   + Sort theo param mà client truyền vào (dạng mảng)
     * - Có search:
     *   + Theo name
     *   + Theo ngày tháng (from, to)
     *   + Search theo giáo viên
     *   + Search theo rating (from, to)
     *   + Search theo status
     *   + Search theo số lượng bài học của khóa
     *
     * @param userId ID của người dùng đăng ký
     * @param req Thông tin tìm kiếm khóa học
     * @param size Số lượng bản ghi trên mỗi trang
     * @param page Trang hiện tại
     * @param sort Tiêu chí sắp xếp
     * @return Kết quả tìm kiếm khóa học
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


    /**
     * Học bài học:
     * + Start bài học
     * + Đang học
     * + Kết thúc bài học
     *
     * @param userId ID của người dùng học bài học
     * @param courseId ID của khóa học
     * @param status Trạng thái học (start, in-progress, finish)
     * @return Trạng thái học của người dùng
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