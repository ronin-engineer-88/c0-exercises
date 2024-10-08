package src.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import src.constant.UrlConstant;
import src.dto.request.admin.TeacherCreateReq;
import src.dto.request.admin.TeacherSearchReq;
import src.dto.request.admin.TeacherUpdateReq;
import src.dto.response.admin.TeacherSearchRes;
import src.entity.Teacher;
import src.service.ITeacherService;

@RestController
@RequestMapping(UrlConstant.API_V1)
@RequiredArgsConstructor
public class TeacherController {

    private final ITeacherService teacherService;

    /**
     * Tạo mới một teacher.
     *
     * @param req đối tượng {@link TeacherCreateReq} chứa thông tin teacher cần tạo.
     * @return một ResponseEntity chứa đối tượng {@link Teacher} đã được tạo.
     * @see ITeacherService#createTeacher(TeacherCreateReq)
     */
    @PostMapping(UrlConstant.ADD_TEACHERS)
    public ResponseEntity<?> createTeacher(@Valid @RequestBody TeacherCreateReq req) {
        Teacher createdTeacher = teacherService.createTeacher(req);
        return ResponseEntity.ok(createdTeacher);
    }


    /**
     * update thông tin một teacher cụ thể.
     *
     * @param teacherId ID của Teacher cần cập nhật.
     * @param req       đối tượng {@link TeacherUpdateReq} chứa thông tin update cho teacher.
     * @return          ResponseEntity chứa đối tượng {@link Teacher} đã được cập nhật.
     * @see ITeacherService#updateTeacher(Long, TeacherUpdateReq)
     */
    @PutMapping(UrlConstant.UPDATE_TEACHERS)
    public ResponseEntity<?> updateTeacher(@PathVariable("teacher_id") Long teacherId,
                                           @Valid @RequestBody TeacherUpdateReq req) {
        Teacher updatedTeacher = teacherService.updateTeacher(teacherId, req);
        return ResponseEntity.ok(updatedTeacher);
    }

    /**
     * delete một teacher cụ thể.
     * <p>
     * Xóa mềm có nghĩa là teacher được đánh dấu là đã xóa nhưng không bị xóa vĩnh viễn khỏi cơ sở dữ liệu.
     * </p>
     *
     * @param teacherId ID của teacher cần xóa.
     * @return          ResponseEntity với thông báo thành công.
     * @see ITeacherService#deleteTeacher(Long)
     */
    @DeleteMapping(UrlConstant.DELETE_TEACHERS)
    public ResponseEntity<?> deleteTeacher(@PathVariable("teacher_id") Long teacherId) {
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.ok("Teacher deleted successfully.");
    }


    /**
     * Lấy danh sách Teacher theo phân trang dựa trên các tiêu chí tìm kiếm.
     * <p>
     * Các tiêu chí tìm kiếm bao gồm các field như tên người dùng, tên teacher, trạng thái và khoảng thời gian.
     * </p>
     *
     * @param page        số trang cần lấy, mặc định là 0.
     * @param pageSize    số lượng bản ghi trên mỗi trang, mặc định là 10.
     * @param sort        trường -> kết quả sẽ được sắp xếp, mặc định là "created_date".
     * @param req         đối tượng {@link TeacherSearchReq} chứa các bộ lọc tìm kiếm.
     * @return            ResponseEntity chứa {@link TeacherSearchRes} với kết quả tìm kiếm.
     * @see ITeacherService#getTeachers(int, int, String, TeacherSearchReq)
     */
    @GetMapping(UrlConstant.GET_TEACHERS)
    public ResponseEntity<TeacherSearchRes> getTeachers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "created_date") String sort,
            @Valid @RequestBody TeacherSearchReq req) {

        TeacherSearchRes res = teacherService.getTeachers(page, pageSize, sort, req);
        return ResponseEntity.ok(res);
    }
}

