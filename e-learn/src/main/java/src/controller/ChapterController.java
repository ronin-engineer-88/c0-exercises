package src.controller;

import org.springframework.web.bind.annotation.*;
import src.constant.UrlConstant;
import src.dto.request.admin.ChapterCreateReq;
import src.dto.request.admin.ChapterSearchReq;
import src.dto.request.admin.ChapterUpdateReq;
import src.dto.response.admin.ChapterSearchRes;

import java.util.List;

@RestController
@RequestMapping(UrlConstant.API_V1)
public class ChapterController {

    @PostMapping(UrlConstant.ADD_CHAPTERS)
    public Object addChapters(@PathVariable("course_id") Long courseId,
                              @RequestBody List<ChapterCreateReq> req) {
        return req;
    }

    @PutMapping(UrlConstant.UPDATE_CHAPTERS)
    public Object updateChapter(@PathVariable("course_id") Long courseId,
                                @PathVariable("chapter_id") Long chapterId,
                                @RequestBody ChapterUpdateReq req) {
        return req;
    }

    @DeleteMapping(UrlConstant.DELETE_CHAPTERS)
    public Object softDeleteChapter(@PathVariable("course_id") Long courseId,
                                    @PathVariable("chapter_id") Long chapterId) {
        return chapterId;
    }

    @GetMapping(UrlConstant.GET_CHAPTERS)
    public Object getChapters(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "created_date") String sort,
            @RequestBody ChapterSearchReq req) {

        ChapterSearchRes res = new ChapterSearchRes();
        res.setSort(sort);
        res.setPage(page);
        res.setPageSize(pageSize);
        res.setName(req.getName());
        res.setStatus(req.getStatus());
        res.setCourseId(req.getCourseId());
        res.setCreatedDateFrom(req.getCreatedDateFrom());
        res.setCreatedDateTo(req.getCreatedDateTo());

        return res;
    }
}

