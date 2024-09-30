package src.controller;

import org.springframework.web.bind.annotation.*;
import src.constant.UrlConstant;
import src.dto.request.UserLoginReq;

@RestController
@RequestMapping("/api/v1/admins/")
public class AdminController {

// Đăng nhập
    @PostMapping(UrlConstant.LOGIN)
    public Object login(@RequestBody UserLoginReq req) {
        return req;
    }


// Hiển thị thông tin của user, số lượng khóa học user đã đăng ký
    @GetMapping(UrlConstant.USER_INFO)
    public Object getUserInfo(@PathVariable("user_id") String userId) {
        return userId;
    }


/* Hiển thị chi tiết thông tin user_course (bao gồm cả thông tin user và thông tin course)
   và số lượng bài học đang processing
   và số lượng bài học đã hoàn thành trong khóa học.
*/
    @GetMapping(UrlConstant.USER_COURSE_INFO)
    public Object getUserCourseInfo(@PathVariable("user_course_id") String userCourseId) {
        return userCourseId;
    }


/* UserCourseLession: Hiển thị chi tiết bài học và trạng thái
   của user đó đã học (bao gồm cả thông tin user và thông tin course và thông tin bài học)
*/
    @GetMapping(UrlConstant.USER_COURSE_LESSON_INFO)
    public Object getUserCourseLessonInfo(@PathVariable("user_course_lesson_id") String userCourseLessonId){
        return userCourseLessonId;
    }


// Xem chi tiết giáo viên và số lượng khóa học giáo viên đã dạy
    @GetMapping(UrlConstant.TEACHER_INFO)
    public Object getTeacherInfo(@PathVariable("teacher_id") String teacherId) {
        return teacherId;
    }


/*  Xem chi tiết khóa học và số lượng chappter
    và số lượng bài học trong khóa học, và số lượng user đã đăng ký khóa học
*/
    @GetMapping(UrlConstant.COURSE_INFO)
    public Object getCourseInfo(@PathVariable("course_id") String courseId) {
        return courseId;
    }


/* Xem chi tiết chapter: Hiển thị thông tin chi tiết về khóa học
     và chaptter và số lượng bài học trong chapter
*/
    @GetMapping(UrlConstant.CHAPTER_INFO)
    public Object getChapterInfo(@PathVariable("chapter_id") String chapterId) {
        return chapterId;
    }


/* Xem chi tiết bài học: Hiển thị thông tin chi tiết về khóa học và chapter và thông tin bài học
   và số lượng user đã hoàn thành bài học, và số lượng user đang học bài học.
*/
    @GetMapping(UrlConstant.LESSON_INFO)
    public Object getLessonInfo(@PathVariable("lesson_id") String lessonId) {
        return lessonId;
    }
}
