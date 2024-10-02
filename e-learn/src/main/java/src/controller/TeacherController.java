package src.controller;

import org.springframework.web.bind.annotation.*;
import src.constant.UrlConstant;
import src.dto.request.TeacherSearchReq;
import src.dto.request.TeacherUpdateReq;
import src.dto.response.TeacherSearchRes;

@RestController
@RequestMapping(UrlConstant.API_V1)
public class TeacherController {

    @PutMapping(UrlConstant.UPDATE_TEACHERS)
    public Object updateTeacher(@PathVariable("teacher_id") Long teacherId,
                                           @RequestBody TeacherUpdateReq req) {

        return req;
    }

    @DeleteMapping(UrlConstant.DELETE_TEACHERS)
    public Object deleteTeacher(@PathVariable("teacher_id") Long teacherId) {
        return teacherId;
    }

    @GetMapping(UrlConstant.GET_TEACHERS)
    public Object getTeachers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "created_date") String sort,
            @RequestBody TeacherSearchReq req) {

        TeacherSearchRes res = new TeacherSearchRes();
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
}

