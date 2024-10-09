package src.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.dto.request.admin.LessonCreateReq;
import src.dto.request.admin.LessonSearchReq;
import src.dto.request.admin.LessonUpdateReq;
import src.dto.response.admin.LessonSearchRes;
import src.entity.Lesson;
import src.repository.LessonRepository;
import src.service.ILessonService;

import java.util.List;

@Service
public class LessonServiceImpl implements ILessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public List<Lesson> addLessons(Long courseId, Long chapterId, List<LessonCreateReq> req) {
        return null;
    }

    @Override
    public Lesson updateLesson(Long courseId, Long chapterId, Long lessonId, LessonUpdateReq req) {
        return null;
    }

    @Override
    public void softDeleteLesson(Long courseId, Long chapterId, Long lessonId) {
    }

    @Override
    public LessonSearchRes getLessons(int page, int pageSize, String sort, LessonSearchReq req) {
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
