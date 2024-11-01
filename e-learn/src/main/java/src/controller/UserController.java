//package src.controller;
//
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import src.constant.UrlConstant;
//import src.dto.request.user.UserInfoReq;
//import src.dto.request.user.UserLoginReq;
//import src.dto.request.user.UserSearchCourseReq;
//import src.dto.request.user.UserSearchReq;
//import src.service.IUserService;
//
//@RestController
//@RequestMapping(UrlConstant.API_V1)
//public class UserController {
//    private IUserService userService;
//
//    // Using setter injection
//    @Autowired
//    public void setUserService(IUserService userService) {
//        this.userService = userService;
//    }
//
//    /**
//     * User Đăng ký
//     *
//     * @param req Thông tin người dùng cần đăng ký
//     * @return Thông tin người dùng đã đăng ký
//     */
//    @PostMapping(UrlConstant.USER_REGISTER)
//    public ResponseEntity<?> register(@Valid @RequestBody UserInfoReq req) {
//
//        return ResponseEntity.ok(userService.register(req));
//    }
//
//
//    /**
//     * User Đăng nhập
//     *
//     * @param req Thông tin người dùng cần đăng nhập
//     * @return Thông tin người dùng đã đăng nhập
//     */
//    @PostMapping(UrlConstant.USER_LOGIN)
//    public ResponseEntity<?> login(@Valid @RequestBody UserLoginReq req) {
//
//        return ResponseEntity.ok(userService.login(req));
//    }
//
//
//    /**
//     * User Cập nhật thông tin
//     *
//     * @param userId ID của người dùng cần cập nhật
//     * @param req Thông tin người dùng cần cập nhật
//     * @return Thông tin người dùng sau khi cập nhật
//     */
//    @PutMapping(UrlConstant.UPDATE_USER)
//    public ResponseEntity<?> userUpdate(
//            @PathVariable("user_id") Long userId,
//            @Valid @RequestBody UserInfoReq req) {
//
//        return ResponseEntity.ok(userService.updateUser(userId, req));
//    }
//
//
//    /**
//     * User xóa tài khoản
//     *
//     * @param userId ID của người dùng xóa tài khoaản
//     * @return Thông tin người dùng sau khi xóa tài khoản
//     */
//    @DeleteMapping(UrlConstant.DELETE_USERS)
//    public ResponseEntity<?> softDeleteUser(@PathVariable("user_id") Long userId) {
//
//        return ResponseEntity.ok(userService.deleteUser(userId));
//    }
//
//
//    /**
//     * Lấy danh sách users với phân trang và sắp xếp.
//     *
//     * @param page trang hiện tại
//     * @param pageSize số lượng bản ghi trên mỗi trang
//     * @param sort tiêu chí sắp xếp
//     * @param req tiêu chí tìm kiếm người dùng
//     * @return danh sách người dùng phù hợp với tiêu chí tìm kiếm
//     */
//    @GetMapping(UrlConstant.GET_USERS)
//    public ResponseEntity<?> getUsers(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int pageSize,
//            @RequestParam(defaultValue = "created_date") String sort,
//            @RequestBody UserSearchReq req) {
//
//        return ResponseEntity.ok(userService.getUsers(page, pageSize, sort, req));
//    }
//
//
//    /**
//     * User Đăng ký khóa học
//     *
//     * @param userId ID của người dùng đăng ký khóa học
//     * @param courseId ID của khóa học cần đăng ký
//     * @return Thông tin về việc đăng ký khóa học
//     */
//    @PostMapping(UrlConstant.USER_ENROLL_COURSE)
//    public ResponseEntity<?> enroll(
//            @PathVariable("user_id") Long userId,
//            @PathVariable("course_id") Long courseId) {
//
//        return ResponseEntity.ok(userService.enrollCourse(userId, courseId));
//    }
//
//
//    /**
//     * User Đánh giá khóa học
//     *
//     * @param userId ID của người dùng đánh giá khóa học
//     * @param courseId ID của khóa học cần đánh giá
//     * @param rate Điểm đánh giá của người dùng
//     * @return Thông tin về đánh giá của người dùng
//     */
//    @PostMapping(UrlConstant.USER_RATE_COURSE)
//    public ResponseEntity<?> rateCourse(
//            @PathVariable("user_id") Long userId,
//            @PathVariable("course_id") Long courseId,
//            @RequestBody Integer rate) {
//
//        return ResponseEntity.ok(userService.rateCourse(userId, courseId, rate));
//    }
//
//
//    /**
//     * User viết nhận xét
//     *
//     * @param userId ID của người dùng viết nhận xét
//     * @param courseId ID của khóa học cần nhận xét
//     * @param review Nội dung nhận xét
//     * @return Thông tin về nhận xét của người dùng
//     */
//    @PostMapping(UrlConstant.USER_REVIEW_COURSE)
//    public ResponseEntity<?> commentCourse(
//            @PathVariable("user_id") Long userId,
//            @PathVariable("course_id") Long courseId,
//            @RequestBody String review) {
//
//        return ResponseEntity.ok(userService.reviewCourse(userId, courseId, review));
//    }
//
//
//    /**
//     * User xem chi tiết khóa học
//     *
//     * @param courseId ID của khóa học cần xem
//     * @return Thông tin chi tiết của khóa học
//     */
//    @GetMapping(UrlConstant.USER_VIEW_COURSE_INFO)
//    public ResponseEntity<?> viewCourseInfo(@PathVariable("course_id") Long courseId) {
//
//        return ResponseEntity.ok(userService.getCourseInfo(courseId));
//    }
//
//
//    /**
//     * User Xem danh sách & tìm kiếm khóa học mà user đăng ký
//     * - Không search gì => Hiển thị danh sách theo pagging và sorting
//     *   + Mặc định là hiển thị 10 bản ghi mới nhất
//     *   + Sort theo param mà client truyền vào (dạng mảng)
//     * - Có search:
//     *   + Theo name
//     *   + Theo ngày tháng (from, to)
//     *   + Search theo giáo viên
//     *   + Search theo rating (from, to)
//     *   + Search theo status
//     *   + Search theo số lượng bài học của khóa
//     *
//     * @param userId ID của người dùng đăng ký
//     * @param req Thông tin tìm kiếm khóa học
//     * @param pageSize Số lượng bản ghi trên mỗi trang
//     * @param page Trang hiện tại
//     * @param sort Tiêu chí sắp xếp
//     * @return Kết quả tìm kiếm khóa học
//     */
//    @GetMapping(UrlConstant.USER_SEARCH_REGISTERED_COURSE)
//    public ResponseEntity<?> searchRegisteredCourse(
//            @PathVariable("user_id") Long userId,
//            @RequestBody UserSearchCourseReq req,
//            @RequestParam(defaultValue = "0") Integer page,
//            @RequestParam(defaultValue = "10") Integer pageSize,
//            @RequestParam(defaultValue = "created_date") String sort) {
//
//        return ResponseEntity.ok(userService.getRegisterCourse(userId, req, page, pageSize, sort));
//    }
//
//
//    /**
//     * Học bài học:
//     * + Start bài học
//     * + Đang học
//     * + Kết thúc bài học
//     *
//     * @param userId ID của người dùng học bài học
//     * @param courseId ID của khóa học
//     * @param status Trạng thái học (start, in-progress, finish)
//     * @return Trạng thái học của người dùng
//     */
//    @PatchMapping(UrlConstant.USER_STUDY)
//    public ResponseEntity<?> study(
//            @PathVariable("user_id") Long userId,
//            @PathVariable("course_id") Long courseId,
//            @RequestBody String status) {
//
//        return ResponseEntity.ok(userService.study(userId, courseId, status));
//    }
//}