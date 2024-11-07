package src.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import src.entity.Chapter;
import src.entity.Course;
import src.exception.AppException;
import src.repository.ChapterRepository;
import src.repository.CourseRepository;

import java.util.Objects;

@Component
public class ValidateUtils {

    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Chapter validateCourseAndChapter(Long courseId, Long chapterId) {
        Course course = courseRepository.getCourseById(courseId)
                .orElseThrow(() -> new AppException("Course not found with id: " + courseId));

        Chapter chapter = chapterRepository.getChapterById(chapterId)
                .orElseThrow(() -> new AppException("Chapter not found with id: " + chapterId));


        if (!chapter.getCourse().getId().equals(course.getId())) {
            throw new AppException("Chapter does not belong to the specified course");
        }

        return chapter;
    }

}
