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
import src.dto.request.admin.CourseCreateReq;
import src.dto.request.admin.CourseSearchReq;
import src.dto.request.admin.CourseUpdateReq;
import src.dto.response.admin.CourseResponseDto;
import src.dto.response.admin.CourseSearchRes;
import src.entity.Course;
import src.entity.Teacher;
import src.exception.CourseNotFoundException;
import src.exception.TeacherNotFoundException;
import src.repository.CourseRepository;
import src.repository.TeacherRepository;
import src.service.ICourseService;
import src.util.DateUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements ICourseService {

    private static final Logger log = LoggerFactory.getLogger(ICourseService.class);

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public CourseResponseDto createCourse(CourseCreateReq req) {
        Course course = new Course();
        BeanUtils.copyProperties(req, course);
        course.setCreatedDate(LocalDateTime.now());
        course.setStatus(ConfigConstant.ACTIVE.getValue());

        assignTeacher(req.getTeacherId(), course);
        Course savedCourse = courseRepository.save(course);

        CourseResponseDto courseRes = new CourseResponseDto();
        BeanUtils.copyProperties(savedCourse, courseRes);
        courseRes.setTeacherId(savedCourse.getTeacher().getId());
        courseRes.setCreatedDate(DateUtils.dateTimeToString(savedCourse.getCreatedDate()));

        return courseRes;
    }

    @Override
    public CourseResponseDto updateCourse(Long courseId, CourseUpdateReq req) {
        Course course = courseRepository.getCourseById(courseId);
        if (Objects.isNull(course)) {
            throw new CourseNotFoundException("Course not found with id: " + courseId);
        }

        BeanUtils.copyProperties(req, course);
        course.setUpdatedDate(LocalDateTime.now());
        String newStatus = (req.getStatus() == ConfigConstant.INACTIVE.getCode())
                                            ? ConfigConstant.INACTIVE.getValue() : ConfigConstant.ACTIVE.getValue();
        if (!newStatus.equals(course.getStatus())) {
            course.setStatus(newStatus);
        }

        assignTeacher(req.getTeacherId(), course);
        Course savedCourse = courseRepository.save(course);

        CourseResponseDto courseRes = new CourseResponseDto();
        BeanUtils.copyProperties(savedCourse, courseRes);
        courseRes.setTeacherId(savedCourse.getTeacher().getId());
        courseRes.setUpdatedDate(DateUtils.dateTimeToString(savedCourse.getUpdatedDate()));

        return courseRes;
    }

    @Override
    public void softDeleteCourse(Long courseId) {
        Course course = courseRepository.getCourseById(courseId);
        if (Objects.isNull(course)) {
            throw new CourseNotFoundException("Course not found with id: " + courseId);
        }

        course.setStatus(ConfigConstant.INACTIVE.getValue());
        course.setUpdatedDate(LocalDateTime.now());
        courseRepository.save(course);

        log.info("Soft delete course with id: {}", courseId);
    }

    @Override
    public CourseSearchRes getCourses(int page, int pageSize, String sort, CourseSearchReq req) {
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(sort));

        Page<Course> coursePage = courseRepository.findCourses(
                req.getName(),
                req.getStatus(),
                req.getTeacherName(),
                req.getCreatedDateFrom(),
                req.getCreatedDateTo(),
                req.getRatingFrom(),
                req.getRatingTo(),
                pageRequest
        );

        List<Course> courses = coursePage.getContent();
        List<CourseResponseDto> listCourseRes = courses.stream().map(course -> {
                    CourseResponseDto courseRes = new CourseResponseDto();
                    BeanUtils.copyProperties(course, courseRes);
                    return courseRes;
                })
                .collect(Collectors.toList());

        CourseSearchRes res = new CourseSearchRes();
        res.setCourses(listCourseRes);
        res.setTotalElements(coursePage.getTotalElements());
        res.setTotalPages(coursePage.getTotalPages());
        res.setPage(page);
        res.setPageSize(pageSize);
        return res;
    }

    private void assignTeacher(Long teacherId, Course course) {
        if (Objects.nonNull(teacherId)) {
            Teacher teacher = teacherRepository.getTeacherById(teacherId);
            if (Objects.isNull(teacher)) {
                throw new TeacherNotFoundException("Teacher not found with id: " + teacherId);
            }
            if (ConfigConstant.INACTIVE.getValue().equals(teacher.getStatus())) {
                throw new IllegalStateException("Teacher is already 'inactive'");
            }
            course.setTeacher(teacher);
        }
    }
}
