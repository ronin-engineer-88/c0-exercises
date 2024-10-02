package src.controller;

import org.springframework.web.bind.annotation.*;
import src.constant.UrlConstant;
import src.dto.request.CourseCreateReq;
import src.dto.request.CourseSearchReq;
import src.dto.request.CourseUpdateReq;
import src.dto.response.CourseSearchRes;

@RestController
@RequestMapping()
public class CourseController {

    @PostMapping(UrlConstant.ADD_COURSES)
    public Object addCourse(@RequestBody CourseCreateReq req) {
        return req;
    }

    @PutMapping(UrlConstant.UPDATE_COURSES)
    public Object updateCourse(@PathVariable("course_id") Long courseId,
                               @RequestBody CourseUpdateReq req) {
        return req;
    }

    @DeleteMapping(UrlConstant.DELETE_COURSES)
    public Object softDeleteCourse(@PathVariable("course_id") Long courseId) {
        return courseId;
    }

    @GetMapping(UrlConstant.GET_COURSES)
    public Object getCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "created_date") String sort,
            @RequestBody CourseSearchReq req) {

        CourseSearchRes res = new CourseSearchRes();
        res.setSort(sort);
        res.setPage(page);
        res.setPageSize(pageSize);
        res.setName(req.getName());
        res.setStatus(req.getStatus());
        res.setTeacherName(res.getTeacherName());
        res.setCreatedDateFrom(req.getCreatedDateFrom());
        res.setCreatedDateTo(req.getCreatedDateTo());
        res.setRatingFrom(req.getRatingFrom());
        res.setRatingTo(req.getRatingTo());

        return res;
    }
}

