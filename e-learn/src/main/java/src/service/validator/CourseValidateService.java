package src.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.constant.ConfigConstant;
import src.entity.Chapter;
import src.entity.Course;
import src.entity.Lesson;
import src.exception.CourseException.CourseInactiveException;
import src.exception.CourseException.CourseNotFoundException;
import src.exception.LessonException.NoLessonInCourseException;
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

    public void validateActiveCourse(Course course) {
        if(course.getStatus().equals(ConfigConstant.INACTIVE.getValue()))
            throw new CourseInactiveException("Course is now unavailable!");
    }

    public void checkIfCourseHasLesson(Course course, Lesson lesson) {
        for(Chapter ch : course.getChapters()) {
            if(ch.getLessons().contains(lesson))
                return;
        }
        throw new NoLessonInCourseException(
                "Course with id: " + course.getId() +
                        " does not have lesson with id: " + lesson.getId());
    }

}
