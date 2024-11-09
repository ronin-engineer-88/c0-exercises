package src.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import src.exception.AppException;
import src.repository.ChapterRepository;
import src.repository.CourseRepository;
import src.repository.LessonRepository;
import src.service.ILessonService;
import src.utils.DateUtils;
import src.utils.PageableUtils;
import src.utils.ValidateUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements ILessonService {

    private static final Logger log = LoggerFactory.getLogger(ILessonService.class);

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
            lesson.setCreatedDate(new Date());
            return lesson;
        }).collect(Collectors.toList());

        List<Lesson> savedLesson = lessonRepository.saveAll(lessons);
        List<LessonResDto> res = savedLesson.stream().map(lesson -> {
            LessonResDto lessonResDto = new LessonResDto();
            BeanUtils.copyProperties(lesson, lessonResDto);
            lessonResDto.setChapterId(lesson.getChapter().getId());
            lessonResDto.setCreatedDate(DateUtils.formatDate(lesson.getCreatedDate()));
            return lessonResDto;
        }).collect(Collectors.toList());

        return res;
    }

    @Override
    public LessonResDto updateLesson(Long courseId, Long chapterId, Long lessonId, LessonUpdateReq req) {
        // validateRequest
        Chapter chapter = validateUtils.validateCourseAndChapter(courseId, chapterId);
        if (req.getStatus() != null && (ConfigConstant.INACTIVE.getCode() != req.getStatus()
                && ConfigConstant.ACTIVE.getCode() != req.getStatus())) {
            throw new AppException("Status must be 0 (inactive) or 1 (active)");
        }

        Lesson lesson = lessonRepository.getLessonById(lessonId);
        if (Objects.isNull(lesson)) {
            throw new AppException("Lesson not found with id: " + lessonId);
        }

        if (!chapter.getId().equals(lesson.getChapter().getId())) {
            throw new AppException("Lesson does not belong to the specified chapter");
        }

        if (req.getStatus() != null) {
            String newStatus = (req.getStatus() == ConfigConstant.INACTIVE.getCode())
                    ? ConfigConstant.INACTIVE.getValue()
                    : ConfigConstant.ACTIVE.getValue();

            if (!newStatus.equals(lesson.getStatus())) lesson.setStatus(newStatus);
        }
        Optional.ofNullable(req.getName()).ifPresent(lesson::setName);
        Optional.ofNullable(req.getType()).ifPresent(lesson::setType);
        Optional.ofNullable(req.getUrl()).ifPresent(lesson::setUrl);
        Optional.ofNullable(req.getDescription()).ifPresent(lesson::setDescription);
        lesson.setUpdatedDate(new Date());

        lessonRepository.save(lesson);

        LessonResDto res = new LessonResDto();
        BeanUtils.copyProperties(lesson, res);

        return res;
    }

    @Override
    public void softDeleteLesson(Long courseId, Long chapterId, Long lessonId) {
        Lesson lesson = lessonRepository.getLessonById(lessonId);
        if (Objects.isNull(lesson)) {
            throw new AppException("Lesson not found with id: " + lessonId);
        }

        if (ConfigConstant.INACTIVE.getValue().equalsIgnoreCase(lesson.getStatus())) {
            throw new AppException("Lesson is already inactive");
        }

        lesson.setStatus(ConfigConstant.INACTIVE.getValue());
        lesson.setUpdatedDate(new Date());
        lessonRepository.save(lesson);

        log.info("Soft delete lesson with id: {}", lessonId);
    }

    @Override
    public LessonSearchRes getLessons(LessonSearchReq req) {
        if (Objects.nonNull(req.getCourseId()) && !courseRepository.existsById(req.getCourseId())) {
            throw new AppException("Course not found with id: " + req.getCourseId());
        }

        if (Objects.nonNull(req.getChapterId()) && !chapterRepository.existsById(req.getChapterId())) {
            throw new AppException("Chapter not found with id: " + req.getChapterId());
        }

        req.setPageIndex(req.getPageIndex() != null && req.getPageIndex() >= 0 ? req.getPageIndex() : 0);
        req.setPageSize(req.getPageSize() != null && req.getPageSize() >= 1 ? req.getPageSize() : 10);
        //
        Sort sort = PageableUtils.determineSort(req.getSort());
        Pageable pageable = PageRequest.of(req.getPageIndex(), req.getPageSize(), sort);

        Page<Lesson> lessonPage = lessonRepository.findLessons(
                req.getName(),
                req.getStatus(),
                req.getCourseId(),
                req.getChapterId(),
                req.getType(),
                DateUtils.stringToDate(req.getCreatedDateFrom()),
                DateUtils.stringToDate(req.getCreatedDateTo()),
                pageable
        );

        List<LessonResDto> listLessonRes = lessonPage.getContent().stream()
                .map(lesson -> {
                    LessonResDto lessonResDto = new LessonResDto();
                    BeanUtils.copyProperties(lesson, lessonResDto);
                    return lessonResDto;
                }).collect(Collectors.toList());

        LessonSearchRes res = new LessonSearchRes();
        res.setLessons(listLessonRes);
        res.setTotalItems(lessonPage.getTotalElements());
        return res;
    }

    @Override
    public void deleteByStatus(String value) {
        lessonRepository.deleteByStatus(value);
    }
}
