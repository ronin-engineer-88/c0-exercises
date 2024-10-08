package src.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.dto.request.admin.ChapterCreateReq;
import src.dto.request.admin.ChapterSearchReq;
import src.dto.request.admin.ChapterUpdateReq;
import src.dto.response.admin.ChapterSearchRes;
import src.entity.Chapter;
import src.repository.ChapterRepository;
import src.service.IChapterService;
import java.util.List;

@Service
public class ChapterServiceImpl implements IChapterService {

    @Autowired
    private ChapterRepository chapterRepository;

    @Override
    public List<Chapter> addChapters(Long courseId, List<ChapterCreateReq> chapterCreateReqs) {
        return null;
    }

    @Override
    public Chapter updateChapter(Long courseId, Long chapterId, ChapterUpdateReq req) {
        return null;
    }

    @Override
    public void softDeleteChapter(Long courseId, Long chapterId) {
    }

    @Override
    public ChapterSearchRes getChapters(int page, int pageSize, String sort, ChapterSearchReq req) {
        ChapterSearchRes res = new ChapterSearchRes();
        res.setPage(page);
        res.setPageSize(pageSize);
        res.setSort(sort);
        res.setName(req.getName());
        res.setStatus(req.getStatus());
        res.setCourseId(req.getCourseId());
        res.setCreatedDateFrom(req.getCreatedDateFrom());
        res.setCreatedDateTo(req.getCreatedDateTo());
        return res;
    }
}
