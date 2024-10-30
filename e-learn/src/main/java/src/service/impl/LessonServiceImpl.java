package src.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import src.constant.ConfigConstant;
import src.dto.request.admin.LessonCreateReq;
import src.dto.request.admin.LessonSearchReq;
import src.dto.request.admin.LessonUpdateReq;
import src.dto.response.admin.LessonResDto;
import src.dto.response.admin.LessonSearchRes;
import src.entity.Chapter;
import src.entity.Lesson;
import src.exception.LessonNotFoundException;
import src.repository.ChapterRepository;
import src.repository.CourseRepository;
import src.repository.LessonRepository;
import src.service.ICourseService;
import src.service.ILessonService;
import src.util.DateUtils;
import src.util.ValidateUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements ILessonService {

    private static final Logger log = LoggerFactory.getLogger(ICourseService.class);

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private ValidateUtils validateUtils;

    @Override
    public List<LessonResDto> addLessons(Long courseId, Long chapterId, List<LessonCreateReq> req) {
        // validateRequest
        Chapter chapter = validateUtils.validateCourseAndChapter(courseId, chapterId);

        List<Lesson> lessons = req.stream().map(createReq -> {
            Lesson lesson = new Lesson();
            BeanUtils.copyProperties(createReq, lesson);
            lesson.setStatus(ConfigConstant.ACTIVE.getValue());
            lesson.setChapter(chapter);
            lesson.setCreatedDate(LocalDateTime.now());
            return lesson;
        }).collect(Collectors.toList());

        List<Lesson> savedLesson = lessonRepository.saveAll(lessons);
        List<LessonResDto> res = savedLesson.stream().map(lesson -> {
            LessonResDto lessonResDto = new LessonResDto();
            BeanUtils.copyProperties(lesson, lessonResDto);
            lessonResDto.setChapterId(lesson.getChapter().getId());
            lessonResDto.setCreatedDate(DateUtils.dateTimeToString(lesson.getCreatedDate()));
            return lessonResDto;
        }).collect(Collectors.toList());

        return res;
    }

    @Override
    public LessonResDto updateLesson(Long courseId, Long chapterId, Long lessonId, LessonUpdateReq req) {
        // validateRequest
        Chapter chapter = validateUtils.validateCourseAndChapter(courseId, chapterId);

        Lesson lesson = lessonRepository.getLessonById(lessonId);
        if (Objects.isNull(lesson)) {
            throw new LessonNotFoundException("Lesson not found with id: " + lessonId);
        }

        if (!chapter.getId().equals(lesson.getChapter().getId())) {
            throw new LessonNotFoundException("Lesson does not belong to the specified chapter");
        }

        BeanUtils.copyProperties(req, lesson);
        lesson.setUpdatedDate(LocalDateTime.now());
        lesson.setDescription(req.getDescription() != null ? req.getDescription() : null);
        String newStatus = (req.getStatus() == ConfigConstant.INACTIVE.getCode())
                ? ConfigConstant.INACTIVE.getValue() : ConfigConstant.ACTIVE.getValue();
        if (!newStatus.equals(chapter.getStatus())) {
            chapter.setStatus(newStatus);
        }

        lessonRepository.save(lesson);

        LessonResDto res = new LessonResDto();
        BeanUtils.copyProperties(lesson, res);
        return res;
    }

    @Override
    public void softDeleteLesson(Long courseId, Long chapterId, Long lessonId) {
        Lesson lesson = lessonRepository.getLessonById(lessonId);
        if (Objects.isNull(lesson)) {
            throw new LessonNotFoundException("Lesson not found with id: " + lessonId);
        }

        lesson.setStatus(ConfigConstant.INACTIVE.getValue());
        lesson.setUpdatedDate(LocalDateTime.now());
        lessonRepository.save(lesson);

        log.info("Soft delete lesson with id: {}", lessonId);
    }

    @Override
    public LessonSearchRes getLessons(int page, int pageSize, String sort, LessonSearchReq req) {
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(sort));

        Page<Lesson> lessonPage = lessonRepository.findLessons(
                req.getName(),
                req.getStatus(),
                req.getCourseId(),
                req.getChapterId(),
                req.getType(),
                req.getCreatedDateFrom(),
                req.getCreatedDateTo(),
                pageRequest
        );

        List<Lesson> lessons = lessonPage.getContent();
        List<LessonResDto> listLessonRes = lessons.stream().map(lesson -> {
            LessonResDto lessonResDto = new LessonResDto();
            BeanUtils.copyProperties(lesson, lessonResDto);
            return lessonResDto;
        }).collect(Collectors.toList());

        LessonSearchRes res = new LessonSearchRes();
        res.setLessons(listLessonRes);
        res.setTotalElements(lessonPage.getTotalElements());
        res.setTotalPages(lessonPage.getTotalPages());
        res.setPage(page);
        res.setPageSize(pageSize);
        return res;
    }
}
