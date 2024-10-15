package src.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.constant.ConfigConstant;
import src.dto.request.admin.CourseCreateReq;
import src.dto.request.admin.CourseSearchReq;
import src.dto.request.admin.CourseUpdateReq;
import src.dto.response.admin.CourseSearchRes;
import src.entity.Course;
import src.entity.Teacher;
import src.exception.CourseNotFoundException;
import src.exception.TeacherNotFoundException;
import src.repository.CourseRepository;
import src.repository.TeacherRepository;
import src.service.ICourseService;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class CourseServiceImpl implements ICourseService {

    private static final Logger log = LoggerFactory.getLogger(ICourseService.class);

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Course createCourse(CourseCreateReq req) {
        Course course = new Course();
        BeanUtils.copyProperties(req, course);
        course.setCreatedDate(LocalDateTime.now());

        assignTeacher(req.getTeacherId(), course);
        Course savedCourse = courseRepository.save(course);
        return savedCourse;
    }

    @Override
    public Course updateCourse(Long courseId, CourseUpdateReq req) {
        Course course = courseRepository.getCourseById(courseId);
        if (Objects.isNull(course)) {
            throw new CourseNotFoundException("Course not found with id: " + courseId);
        }

        BeanUtils.copyProperties(req, course);
        course.setUpdatedDate(LocalDateTime.now());

        assignTeacher(req.getTeacherId(), course);
        return courseRepository.save(course);
    }

    @Override
    public void softDeleteCourse(Long courseId) {
        Course course = courseRepository.getCourseById(courseId);
        if (Objects.isNull(course)) {
            throw new CourseNotFoundException("Course not found with id: " + courseId);
        }

        if (course.getStatus().equals(ConfigConstant.INACTIVE.getValue())) {
            throw new IllegalStateException("Course is already 'inactive'");
        }

        course.setStatus(ConfigConstant.INACTIVE.getValue());
        course.setUpdatedDate(LocalDateTime.now());
        courseRepository.save(course);

        log.info("Soft delete course with id: {}", courseId);
    }

    @Override
    public CourseSearchRes getCourses(int page, int pageSize, String sort, CourseSearchReq req) {
        CourseSearchRes res = new CourseSearchRes();
        res.setSort(sort);
        res.setPage(page);
        res.setPageSize(pageSize);
        res.setName(req.getName());
        res.setStatus(req.getStatus());
        res.setTeacherName(res.getTeacherName());
        res.setCreatedDateFrom(req.getCreatedDateFrom());
        res.setCreatedDateTo(req.getCreatedDateTo());
        res.setRatingFrom(req.getRatingFrom());
        res.setRatingTo(req.getRatingTo());

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
