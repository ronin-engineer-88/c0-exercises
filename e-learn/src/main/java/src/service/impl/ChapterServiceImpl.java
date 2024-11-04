package src.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import src.constant.ConfigConstant;
import src.dto.request.admin.ChapterCreateReq;
import src.dto.request.admin.ChapterSearchReq;
import src.dto.request.admin.ChapterUpdateReq;
import src.dto.response.admin.ChapterResponseDto;
import src.dto.response.admin.ChapterSearchRes;
import src.entity.Chapter;
import src.entity.Course;
import src.exception.AppException;
import src.repository.ChapterRepository;
import src.repository.CourseRepository;
import src.service.IChapterService;
import src.utils.DateUtils;
import src.utils.PageableUtils;
import src.utils.ValidateUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChapterServiceImpl implements IChapterService {

    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ValidateUtils validateUtils;

    @Override
    public List<ChapterResponseDto> addChapters(Long courseId, List<ChapterCreateReq> chapterCreateReqs) {
        Course course = courseRepository.getCourseById(courseId);
        if (Objects.isNull(course)) {
            throw new AppException("Course not found with id: " + courseId);
        }

        List<Chapter> chapters = chapterCreateReqs.stream().map(req -> {
            Chapter chapter = new Chapter();
            chapter.setName(req.getName());
            chapter.setDescription(req.getDescription() != null ? req.getDescription() : null);
            chapter.setOrder(req.getOrder() != null ? req.getOrder() : null);
            chapter.setStatus(ConfigConstant.ACTIVE.getValue());
            chapter.setCourse(course);
            chapter.setCreatedDate(new Date());
            return chapter;
        }).collect(Collectors.toList());

        List<Chapter> savedListChapter = chapterRepository.saveAll(chapters);
        List<ChapterResponseDto> res = savedListChapter.stream().map(chapter -> {
            ChapterResponseDto chapterRes = new ChapterResponseDto();
            BeanUtils.copyProperties(chapter, chapterRes);
            chapterRes.setCreatedDate(DateUtils.formatDate(chapter.getCreatedDate()));
            return chapterRes;
        }).collect(Collectors.toList());

        return res;
    }

    @Override
    public ChapterResponseDto updateChapter(Long courseId, Long chapterId, ChapterUpdateReq req) {
        // validate req
        if (req.getStatus() != null && (ConfigConstant.INACTIVE.getCode() != req.getStatus()
                && ConfigConstant.ACTIVE.getCode() != req.getStatus())) {
            throw new AppException("Status must be 0 (inactive) or 1 (active)");
        }
        Chapter chapter = validateUtils.validateCourseAndChapter(courseId, chapterId);

        if (req.getStatus() != null) {
            String newStatus = (req.getStatus() == ConfigConstant.INACTIVE.getCode())
                    ? ConfigConstant.INACTIVE.getValue()
                    : ConfigConstant.ACTIVE.getValue();

            if (!newStatus.equals(chapter.getStatus())) chapter.setStatus(newStatus);
        }

        Optional.ofNullable(req.getName()).ifPresent(chapter::setName);
        Optional.ofNullable(req.getDescription()).ifPresent(chapter::setDescription);
        Optional.ofNullable(req.getOrder()).ifPresent(chapter::setOrder);

        chapter.setUpdatedDate(new Date());

        Chapter savedChapter = chapterRepository.save(chapter);
        ChapterResponseDto chapterUpdateRes = new ChapterResponseDto();
        BeanUtils.copyProperties(savedChapter, chapterUpdateRes);

        return chapterUpdateRes;
    }

    @Override
    public void softDeleteChapter(Long courseId, Long chapterId) {
        Chapter chapter = validateUtils.validateCourseAndChapter(courseId, chapterId);

        chapter.setStatus(ConfigConstant.INACTIVE.getValue());
        chapter.setUpdatedDate(new Date());

        chapterRepository.save(chapter);
    }

    @Override
    public ChapterSearchRes getChapters(ChapterSearchReq req) {
        req.setPageIndex(req.getPageIndex() != null && req.getPageIndex() >= 0 ? req.getPageIndex() : 0);
        req.setPageSize(req.getPageSize() != null && req.getPageSize() >= 1 ? req.getPageSize() : 10);
        //
        Sort sort = PageableUtils.determineSort(req.getSort());
        Pageable pageable = PageRequest.of(req.getPageIndex(), req.getPageSize(), sort);

        Page<Chapter> chapterPage = chapterRepository.findChapter(
                req.getName(),
                req.getStatus(),
                DateUtils.stringToDate(req.getCreatedDateFrom()),
                DateUtils.stringToDate(req.getCreatedDateTo()),
                pageable
        );

        List<ChapterResponseDto> listChapterRes = chapterPage.getContent().stream()
                .map(chapter -> {
                    ChapterResponseDto chapterRes = new ChapterResponseDto();
                    BeanUtils.copyProperties(chapter, chapterRes);
                    return chapterRes;
                })
                .collect(Collectors.toList());

        ChapterSearchRes res = new ChapterSearchRes();
        res.setChapters(listChapterRes);
        res.setTotalItems(chapterPage.getTotalElements());

        return res;
    }
}
