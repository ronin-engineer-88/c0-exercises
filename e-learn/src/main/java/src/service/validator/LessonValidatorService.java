package src.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.constant.ConfigConstant;
import src.entity.Lesson;
import src.exception.CourseException.CourseInactiveException;
import src.exception.LessonException.LessonNotFoundException;
import src.repository.LessonRepository;

@Service
public class LessonValidatorService {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonValidatorService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Lesson validateLessonExist(Long lessonId) {
        return lessonRepository.getLessonById(lessonId)
                .orElseThrow(
                        () -> new LessonNotFoundException("Not found lesson with id: " + lessonId));
    }

    public void validateActiveLesson(Lesson lesson) {
        if(lesson.getStatus().equals(ConfigConstant.INACTIVE.getValue()))
            throw new CourseInactiveException("Lesson is now unavailable!");
    }

}
