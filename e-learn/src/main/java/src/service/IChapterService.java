package src.service;

import src.dto.request.admin.ChapterCreateReq;
import src.dto.request.admin.ChapterSearchReq;
import src.dto.request.admin.ChapterUpdateReq;
import src.dto.response.admin.ChapterSearchRes;
import src.entity.Chapter;

import java.util.List;

public interface IChapterService {
    List<Chapter> addChapters(Long courseId, List<ChapterCreateReq> chapterCreateReqs);
    Chapter updateChapter(Long courseId, Long chapterId, ChapterUpdateReq req);
    void softDeleteChapter(Long courseId, Long chapterId);
    ChapterSearchRes getChapters(int page, int pageSize, String sort, ChapterSearchReq req);
}
