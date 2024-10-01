package src.controller;

import org.springframework.web.bind.annotation.*;
import src.constant.UrlConstant;
import src.dto.request.UserLoginReq;

@RestController
@RequestMapping("/api/v1/admins/")
public class AdminController {

    /**
     * Đăng nhập cho Admin
     *
     * @param req Thông tin đăng nhập của Admin
     * @return Thông tin đăng nhập Admin
     */
    @PostMapping(UrlConstant.LOGIN)
    public Object login(@RequestBody UserLoginReq req) {
        return req;
    }


    /**
     * Hiển thị thông tin của user, bao gồm số lượng khóa học đã đăng ký
     *
     * @param userId ID của người dùng
     * @return Thông tin của người dùng và số lượng khóa học đã đăng ký
     */
    @GetMapping(UrlConstant.USER_INFO)
    public Object getUserInfo(@PathVariable("user_id") String userId) {
        return userId;
    }


    /**
     * Hiển thị chi tiết thông tin user_course, bao gồm thông tin user, thông tin khóa học,
     * số lượng bài học đang xử lý và đã hoàn thành trong khóa học
     *
     * @param userCourseId ID của user_course
     * @return Thông tin chi tiết của user_course
     */
    @GetMapping(UrlConstant.USER_COURSE_INFO)
    public Object getUserCourseInfo(@PathVariable("user_course_id") String userCourseId) {
        return userCourseId;
    }


    /**
     * Hiển thị chi tiết bài học và trạng thái của người dùng, bao gồm thông tin user,
     * khóa học và bài học
     *
     * @param userCourseLessonId ID của user_course_lesson
     * @return Thông tin chi tiết của bài học và trạng thái học của người dùng
     */
    @GetMapping(UrlConstant.USER_COURSE_LESSON_INFO)
    public Object getUserCourseLessonInfo(@PathVariable("user_course_lesson_id") String userCourseLessonId){
        return userCourseLessonId;
    }


    /**
     * Hiển thị thông tin chi tiết về giáo viên và số lượng khóa học giáo viên đã dạy
     *
     * @param teacherId ID của giáo viên
     * @return Thông tin chi tiết của giáo viên và số lượng khóa học đã dạy
     */
    @GetMapping(UrlConstant.TEACHER_INFO)
    public Object getTeacherInfo(@PathVariable("teacher_id") String teacherId) {
        return teacherId;
    }


    /**
     * Hiển thị chi tiết khóa học, bao gồm số lượng chương, bài học và số lượng người dùng đã đăng ký khóa học
     *
     * @param courseId ID của khóa học
     * @return Thông tin chi tiết của khóa học
     */
    @GetMapping(UrlConstant.COURSE_INFO)
    public Object getCourseInfo(@PathVariable("course_id") String courseId) {
        return courseId;
    }


    /**
     * Hiển thị thông tin chi tiết về chương, bao gồm số lượng bài học trong chương và chi tiết chương học
     *
     * @param chapterId ID của chương học
     * @return Thông tin chi tiết của chương học
     */
    @GetMapping(UrlConstant.CHAPTER_INFO)
    public Object getChapterInfo(@PathVariable("chapter_id") String chapterId) {
        return chapterId;
    }


    /**
     * Hiển thị thông tin chi tiết về bài học, bao gồm thông tin chương học, số lượng người dùng đã hoàn thành bài học,
     * và số lượng người đang học bài học
     *
     * @param lessonId ID của bài học
     * @return Thông tin chi tiết của bài học
     */
    @GetMapping(UrlConstant.LESSON_INFO)
    public Object getLessonInfo(@PathVariable("lesson_id") String lessonId) {
        return lessonId;
    }
}
