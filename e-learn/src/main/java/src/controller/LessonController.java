package src.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import src.constant.UrlConstant;
import src.dto.request.admin.LessonCreateReq;
import src.dto.request.admin.LessonSearchReq;
import src.dto.request.admin.LessonUpdateReq;
import src.dto.response.admin.LessonSearchRes;
import src.entity.Lesson;
import src.service.ILessonService;

import java.util.List;

@RestController
@RequestMapping(UrlConstant.API_V1)
@RequiredArgsConstructor
public class LessonController {

    private final ILessonService lessonService;

    /**
     * Tạo mới danh sách bài học (lessons) cho một chapter cụ thể.
     *
     * @param courseId   ID của course mà chapter thuộc về.
     * @param chapterId  ID của chapter mà các lessons sẽ được thêm vào.
     * @param req        Danh sách các đối tượng {@link LessonCreateReq} chứa thông tin lessons cần tạo.
     * @return           ResponseEntity chứa ds {@link Lesson} đã được tạo thành công.
     * @see ILessonService#addLessons(Long, Long, List)
     */
    @PostMapping(UrlConstant.ADD_LESSONS)
    public ResponseEntity<?> addLessons(@PathVariable("course_id") Long courseId,
                                        @PathVariable("chapter_id") Long chapterId,
                                        @Valid @RequestBody List<LessonCreateReq> req) {
        List<Lesson> createdLessons = lessonService.addLessons(courseId, chapterId, req);
        return ResponseEntity.ok(createdLessons);
    }


    /**
     * Update thông tin của một bài học (lesson) cụ thể.
     *
     * @param courseId   ID course mà chapter thuộc về.
     * @param chapterId  ID của chapter mà lesson thuộc về.
     * @param lessonId   ID của bài học cần update.
     * @param req        Đối tượng {@link LessonUpdateReq} chứa thông tin update.
     * @return           ResponseEntity chứa đối tượng {@link Lesson} đã được update.
     * @see ILessonService#updateLesson(Long, Long, Long, LessonUpdateReq)
     */
    @PutMapping(UrlConstant.UPDATE_LESSONS)
    public ResponseEntity<?> updateLesson(@PathVariable("course_id") Long courseId,
                                          @PathVariable("chapter_id") Long chapterId,
                                          @PathVariable("lesson_id") Long lessonId,
                                          @Valid @RequestBody LessonUpdateReq req) {
        Lesson updatedLesson = lessonService.updateLesson(courseId, chapterId, lessonId, req);
        return ResponseEntity.ok(updatedLesson);
    }


    /**
     * soft delete 1 lesson cụ thể.
     * @param courseId   ID của course mà chapter thuộc về.
     * @param chapterId  ID của chapter mà lesson thuộc về.
     * @param lessonId   ID của bài học cần delete.
     * @return           ResponseEntity với thông báo thành công.
     * @see ILessonService#softDeleteLesson(Long, Long, Long)
     */
    @DeleteMapping(UrlConstant.DELETE_LESSONS)
    public ResponseEntity<?> softDeleteLesson(@PathVariable("course_id") Long courseId,
                                              @PathVariable("chapter_id") Long chapterId,
                                              @PathVariable("lesson_id") Long lessonId) {
        lessonService.softDeleteLesson(courseId, chapterId, lessonId);
        return ResponseEntity.ok("Lesson soft deleted successfully.");
    }


    /**
     * Lấy danh sách bài học (lessons) với phân trang và các bộ lọc tìm kiếm.
     * <p>
     * Các field search bao gồm tên bài học, trạng thái, loại bài học và khoảng thời gian.
     * </p>
     *
     * @param page        Số trang cần lấy, mặc định là 0.
     * @param pageSize    Số lượng bản ghi trên mỗi trang, mặc định là 10.
     * @param sort        Trường dùng để sắp xếp, mặc định là "created_date".
     * @param req         Đối tượng {@link LessonSearchReq} chứa các field tìm kiếm.
     * @return            ResponseEntity chứa đối tượng {@link LessonSearchRes} với kết quả tìm kiếm.
     * @see ILessonService#getLessons(int, int, String, LessonSearchReq)
     */
    @GetMapping(UrlConstant.GET_LESSONS)
    public ResponseEntity<LessonSearchRes> getLessons(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "created_date") String sort,
            @Valid @RequestBody LessonSearchReq req) {

        LessonSearchRes res = lessonService.getLessons(page, pageSize, sort, req);
        return ResponseEntity.ok(res);
    }
}
