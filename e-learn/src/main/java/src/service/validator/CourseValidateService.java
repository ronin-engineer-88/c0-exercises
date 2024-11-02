package src.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.entity.Course;
import src.exception.CourseException.CourseNotFoundException;
import src.repository.CourseRepository;

@Service
public class CourseValidateService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseValidateService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course validateCourseExist(Long courseId) {
        return courseRepository.getCourseById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Not found course with id: " + courseId));
    }

}

