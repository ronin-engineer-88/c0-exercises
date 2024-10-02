package src.controller;

import org.springframework.web.bind.annotation.*;
import src.constant.UrlConstant;
import src.dto.request.admin.LessonCreateReq;
import src.dto.request.admin.LessonSearchReq;
import src.dto.request.admin.LessonUpdateReq;
import src.dto.response.admin.LessonSearchRes;

import java.util.List;

@RestController
@RequestMapping(UrlConstant.API_V1)
public class LessonController {

    @PostMapping(UrlConstant.ADD_LESSONS)
    public Object addLessons(@PathVariable("course_id") Long courseId,
                             @PathVariable("chapter_id") Long chapterId,
                             @RequestBody List<LessonCreateReq> req) {
        return req;
    }


    @PutMapping(UrlConstant.UPDATE_LESSONS)
    public Object updateLesson(@PathVariable("course_id") Long courseId,
                               @PathVariable("chapter_id") Long chapterId,
                               @PathVariable("lesson_id") Long lessonId,
                               @RequestBody LessonUpdateReq req) {
        return req;
    }


    @DeleteMapping(UrlConstant.DELETE_LESSONS)
    public Object softDeleteLesson(@PathVariable("course_id") Long courseId,
                                   @PathVariable("chapter_id") Long chapterId,
                                   @PathVariable("lesson_id") Long lessonId) {
        return lessonId;
    }

    @GetMapping(UrlConstant.GET_LESSONS)
    public Object getLessons(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "created_date") String sort,
            @RequestBody LessonSearchReq req) {

        LessonSearchRes res = new LessonSearchRes();
        res.setSort(sort);
        res.setPage(page);
        res.setPageSize(pageSize);
        res.setName(req.getName());
        res.setStatus(req.getStatus());
        res.setCourseId(req.getCourseId());
        res.setChapterId(req.getChapterId());
        res.setType(req.getType());
        res.setCreatedDateFrom(req.getCreatedDateFrom());
        res.setCreatedDateTo(req.getCreatedDateTo());

        return res;
    }

}
