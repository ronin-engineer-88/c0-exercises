package src.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.entity.*;
import src.exception.LessonException.NoLessonInCourseException;
import src.repository.UserCourseLessonRepository;

@Service
public class UserCourseLessonValidateService {

    public final UserCourseLessonRepository userCourseLessonRepository;

    @Autowired
    public UserCourseLessonValidateService(UserCourseLessonRepository userCourseLessonRepository) {
        this.userCourseLessonRepository = userCourseLessonRepository;
    }

    public StudentCourseLesson validateCourseHasLesson(StudentCourse sc, Lesson lesson) {
        return userCourseLessonRepository.getStudentCourseLesson(sc, lesson)
                .orElseThrow(() -> new NoLessonInCourseException(
                        "Course with id: " + sc.getCourse().getId() +
                                " does not have lesson with id: " + lesson.getId()));

    }

}