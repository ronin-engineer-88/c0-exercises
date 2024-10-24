package src.service;

import src.dto.request.admin.ChapterCreateReq;
import src.dto.request.admin.ChapterSearchReq;
import src.dto.request.admin.ChapterUpdateReq;
import src.dto.response.admin.ChapterResponseDto;
import src.dto.response.admin.ChapterSearchRes;

import java.util.List;

public interface IChapterService {
    List<ChapterResponseDto> addChapters(Long courseId, List<ChapterCreateReq> chapterCreateReqs);
    ChapterResponseDto updateChapter(Long courseId, Long chapterId, ChapterUpdateReq req);
    void softDeleteChapter(Long courseId, Long chapterId);
    ChapterSearchRes getChapters(int page, int pageSize, String sort, ChapterSearchReq req);
}
