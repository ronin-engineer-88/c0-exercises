package src.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import src.constant.UrlConstant;
import src.dto.request.admin.ChapterCreateReq;
import src.dto.request.admin.ChapterSearchReq;
import src.dto.request.admin.ChapterUpdateReq;
import src.dto.response.admin.ChapterSearchRes;
import src.entity.Chapter;
import src.service.IChapterService;

import java.util.List;

@RestController
@RequestMapping(UrlConstant.API_V1)
@RequiredArgsConstructor
public class ChapterController {

    // use constructor injection
    private final IChapterService chapterService;

    /**
     * Thêm nhiều chapter vào một course cụ thể.
     *
     * @param courseId ID của khóa học mà các chương sẽ được thêm vào.
     * @param req      danh sách các đối tượng {@link ChapterCreateReq} chứa thông tin chapter cần tạo.
     * @return         ResponseEntity chứa danh sách các đối tượng {@link Chapter} đã được tạo.
     * @see IChapterService#addChapters(Long, List)
     */
    @PostMapping(UrlConstant.ADD_CHAPTERS)
    public ResponseEntity<?> addChapters(@PathVariable("course_id") Long courseId,
                                         @RequestBody List<ChapterCreateReq> req) {
        List<Chapter> createdChapters = chapterService.addChapters(courseId, req);
        return ResponseEntity.ok(createdChapters);
    }


    /**
     * Cập nhật một chapter trong một course cụ thể.
     *
     * @param courseId  ID của course mà chapter thuộc về.
     * @param chapterId ID của chapter cần được update.
     * @param req       đối tượng {@link ChapterUpdateReq} chứa thông tin cập nhật cho chapter.
     * @return          ResponseEntity chứa đối tượng {@link Chapter} đã được cập nhật.
     * @see IChapterService#updateChapter(Long, Long, ChapterUpdateReq)
     */
    @PutMapping(UrlConstant.UPDATE_CHAPTERS)
    public ResponseEntity<?> updateChapter(@PathVariable("course_id") Long courseId,
                                           @PathVariable("chapter_id") Long chapterId,
                                           @RequestBody ChapterUpdateReq req) {
        Chapter updatedChapter = chapterService.updateChapter(courseId, chapterId, req);
        return ResponseEntity.ok(updatedChapter);
    }


    /**
     * soft delete chapter trong một course cụ thể.
     * <p>
     * soft delete có nghĩa là chương được đánh dấu là đã xóa nhưng không bị xóa vĩnh viễn khỏi cơ sở dữ liệu.
     * </p>
     *
     * @param courseId  ID của course mà chapter thuộc về.
     * @param chapterId ID của chapter cần được xóa mềm.
     * @return          ResponseEntity với thông báo thành công.
     * @see IChapterService#softDeleteChapter(Long, Long)
     */
    @DeleteMapping(UrlConstant.DELETE_CHAPTERS)
    public ResponseEntity<?> softDeleteChapter(@PathVariable("course_id") Long courseId,
                                               @PathVariable("chapter_id") Long chapterId) {
        chapterService.softDeleteChapter(courseId, chapterId);
        return ResponseEntity.ok("Chapter soft deleted successfully.");
    }


    /**
     * Lấy danh sách chapter theo phân trang dựa vào các field tìm kiếm.
     * <p>
     * Các field tìm kiếm bao gồm các field như tên chapter, status, ID khóa học, và khoảng thời gian.
     * </p>
     *
     * @param page        số trang cần lấy, mặc định là 0.
     * @param pageSize    số lượng bản ghi trên mỗi trang, mặc định là 10.
     * @param sort        trường theo đó kết quả sẽ được sắp xếp, mặc định là "created_date".
     * @param req         đối tượng {@link ChapterSearchReq} chứa các field tìm kiếm.
     * @return            ResponseEntity chứa {@link ChapterSearchRes} với kết quả tìm kiếm.
     * @see IChapterService#getChapters(int, int, String, ChapterSearchReq)
     */
    @GetMapping(UrlConstant.GET_CHAPTERS)
    public ResponseEntity<ChapterSearchRes> getChapters(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int pageSize,
                                                        @RequestParam(defaultValue = "created_date") String sort,
                                                        @Valid @RequestBody ChapterSearchReq req) {
        ChapterSearchRes res = chapterService.getChapters(page, pageSize, sort, req);
        return ResponseEntity.ok(res);
    }
}

