//package src.service.impl;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//import src.constant.ConfigConstant;
//import src.dto.request.admin.ChapterCreateReq;
//import src.dto.request.admin.ChapterSearchReq;
//import src.dto.request.admin.ChapterUpdateReq;
//import src.dto.request.admin.CourseCreateReq;
//import src.dto.response.admin.ChapterResponseDto;
//import src.dto.response.admin.ChapterSearchRes;
//import src.entity.Chapter;
//import src.entity.Course;
//import src.exception.ChapterNotFoundException;
//import src.exception.CourseNotFoundException;
//import src.repository.ChapterRepository;
//import src.repository.CourseRepository;
//import src.service.IChapterService;
//import src.util.DateUtils;
//import src.util.ValidateUtils;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//@Service
//public class ChapterServiceImpl implements IChapterService {
//
//    @Autowired
//    private ChapterRepository chapterRepository;
//
//    @Autowired
//    private CourseRepository courseRepository;
//
//    @Autowired
//    private ValidateUtils validateUtils;
//
//    @Override
//    public List<ChapterResponseDto> addChapters(Long courseId, List<ChapterCreateReq> chapterCreateReqs) {
//        Course course = courseRepository.getCourseById(courseId);
//        if (Objects.isNull(course)) {
//            throw new CourseNotFoundException("Course not found with id: " + courseId);
//        }
//
//        List<Chapter> chapters = chapterCreateReqs.stream().map(req -> {
//            Chapter chapter = new Chapter();
//            chapter.setName(req.getName());
//            chapter.setDescription(req.getDescription() != null ? req.getDescription() : null);
//            chapter.setStatus(ConfigConstant.ACTIVE.getValue());
//            chapter.setOrder(req.getOrder());
//            chapter.setCourse(course);
//            chapter.setCreatedDate(LocalDateTime.now());
//            return chapter;
//        }).collect(Collectors.toList());
//
//        List<Chapter> savedListChapter = chapterRepository.saveAll(chapters);
//        List<ChapterResponseDto> res = savedListChapter.stream().map(chapter -> {
//            ChapterResponseDto chapterRes = new ChapterResponseDto();
//            BeanUtils.copyProperties(chapter, chapterRes);
//            chapterRes.setCreatedDate(DateUtils.dateTimeToString(chapter.getCreatedDate()));
//            return chapterRes;
//        }).collect(Collectors.toList());
//
//        return res;
//    }
//
//    @Override
//    public ChapterResponseDto updateChapter(Long courseId, Long chapterId, ChapterUpdateReq req) {
//        Chapter chapter = validateUtils.validateCourseAndChapter(courseId, chapterId);
//
//        BeanUtils.copyProperties(req, chapter);
//        chapter.setDescription(req.getDescription() != null ? req.getDescription() : null);
//        String newStatus = (req.getStatus() == ConfigConstant.INACTIVE.getCode())
//                ? ConfigConstant.INACTIVE.getValue() : ConfigConstant.ACTIVE.getValue();
//        if (!newStatus.equals(chapter.getStatus())) {
//            chapter.setStatus(newStatus);
//        }
//        chapter.setUpdatedDate(LocalDateTime.now());
//
//        Chapter savedChapter = chapterRepository.save(chapter);
//        ChapterResponseDto chapterUpdateRes = new ChapterResponseDto();
//        BeanUtils.copyProperties(savedChapter, chapterUpdateRes);
//
//        return chapterUpdateRes;
//    }
//
//    @Override
//    public void softDeleteChapter(Long courseId, Long chapterId) {
//        Chapter chapter = validateUtils.validateCourseAndChapter(courseId, chapterId);
//        chapter.setStatus(ConfigConstant.INACTIVE.getValue());
//        chapter.setUpdatedDate(LocalDateTime.now());
//
//        chapterRepository.save(chapter);
//    }
//
//    @Override
//    public ChapterSearchRes getChapters(int page, int pageSize, String sort, ChapterSearchReq req) {
//        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(sort));
//
//        Page<Chapter> chapterPage = chapterRepository.findChapter(
//                req.getName(),
//                req.getStatus(),
//                req.getCreatedDateFrom(),
//                req.getCreatedDateTo(),
//                pageRequest
//        );
//
//        List<Chapter> chapters = chapterPage.getContent();
//        List<ChapterResponseDto> listChapterRes = chapters.stream().map(chapter -> {
//            ChapterResponseDto chapterRes = new ChapterResponseDto();
//            BeanUtils.copyProperties(chapter, chapterRes);
//            return chapterRes;
//        }).collect(Collectors.toList());
//
//        ChapterSearchRes res = new ChapterSearchRes();
//        res.setChapters(listChapterRes);
//        res.setPage(page);
//        res.setPageSize(pageSize);
//        res.setSort(sort);
//        res.setTotalElements(chapterPage.getTotalElements());
//        res.setTotalPages(chapterPage.getTotalPages());
//
//        return res;
//    }
//}
