package src.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import src.constant.UrlConstant;
import src.dto.request.admin.CourseCreateReq;
import src.dto.request.admin.CourseSearchReq;
import src.dto.request.admin.CourseUpdateReq;
import src.dto.response.admin.CourseResponseDto;
import src.dto.response.admin.CourseSearchRes;
import src.entity.Course;
import src.service.ICourseService;

@RestController
@RequestMapping(UrlConstant.API_V1)
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService courseService;

    /**
     * Tạo mới một khóa học.
     *
     * @param req đối tượng {@link CourseCreateReq} chứa thông tin course cần tạo.
     * @return một CourseResponseDto chứa đối tượng {@link Course} đã được tạo.
     * @see ICourseService#createCourse(CourseCreateReq)
     */
    @PostMapping(UrlConstant.ADD_COURSES)
    public CourseResponseDto addCourse(@Valid @RequestBody CourseCreateReq req) {
        CourseResponseDto createdCourse = courseService.createCourse(req);
        return createdCourse;
    }

    /**
     * Update thông tin một khóa học cụ thể.
     *
     * @param courseId ID của khóa học cần cập nhật.
     * @param req      đối tượng {@link CourseUpdateReq} chứa thông tin update cho khóa học.
     * @return         CourseResponseDto chứa đối tượng {@link Course} đã được cập nhật.
     * @see ICourseService#updateCourse(Long, CourseUpdateReq)
     */
    @PutMapping(UrlConstant.UPDATE_COURSES)
    public CourseResponseDto updateCourse(@PathVariable("course_id") Long courseId,
                                          @Valid @RequestBody CourseUpdateReq req) {
        CourseResponseDto updatedCourse = courseService.updateCourse(courseId, req);
        return updatedCourse;
    }

    /**
     * Xóa một khóa học cụ thể (soft delete)
     *
     * @param courseId ID của course cần xóa.
     * @return         ResponseEntity với thông báo thành công.
     * @see ICourseService#softDeleteCourse(Long)
     */
    @DeleteMapping(UrlConstant.DELETE_COURSES)
    public void softDeleteCourse(@PathVariable("course_id") Long courseId) {
        courseService.softDeleteCourse(courseId);
    }

    /**
     * Lấy danh sách khóa học theo phân trang dựa trên các tiêu chí tìm kiếm.
     * <p>
     * Các tiêu chí tìm kiếm bao gồm các field như tên khóa học, trạng thái, tên giáo viên và khoảng thời gian.
     * </p>
     *
     * @param page        số trang cần lấy, mặc định là 0.
     * @param pageSize    số lượng bản ghi trên mỗi trang, mặc định là 10.
     * @param sort        trường -> kết quả sẽ được sắp xếp, mặc định là "created_date".
     * @param req         đối tượng {@link CourseSearchReq} chứa các bộ lọc tìm kiếm.
     * @return            ResponseEntity chứa {@link CourseSearchRes} với kết quả tìm kiếm.
     * @see ICourseService#getCourses(int, int, String, CourseSearchReq)
     */
    @GetMapping(UrlConstant.GET_COURSES)
    public CourseSearchRes getCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "createdDate") String sort,
            @RequestBody(required = false) CourseSearchReq req) {

        if (req == null) {
            req = new CourseSearchReq();
        }

        return courseService.getCourses(page, pageSize, sort, req);
    }
}

