package src.service;

import src.dto.request.admin.LessonCreateReq;
import src.dto.request.admin.LessonSearchReq;
import src.dto.request.admin.LessonUpdateReq;
import src.dto.response.admin.LessonResDto;
import src.dto.response.admin.LessonSearchRes;

import java.util.List;

public interface ILessonService {
    List<LessonResDto> addLessons(Long courseId, Long chapterId, List<LessonCreateReq> req);
    LessonResDto updateLesson(Long courseId, Long chapterId, Long lessonId, LessonUpdateReq req);
    void softDeleteLesson(Long courseId, Long chapterId, Long lessonId);
    LessonSearchRes getLessons(int page, int pageSize, String sort, LessonSearchReq req);
}
