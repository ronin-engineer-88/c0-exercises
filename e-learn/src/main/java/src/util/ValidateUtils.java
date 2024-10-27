package src.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import src.entity.Chapter;
import src.entity.Course;
import src.exception.ChapterNotFoundException;
import src.exception.CourseNotFoundException;
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
        Course course = courseRepository.getCourseById(courseId);
        if (Objects.isNull(course)) {
            throw new CourseNotFoundException("Course not found with id: " + courseId);
        }

        Chapter chapter = chapterRepository.getChapterById(chapterId);
        if (Objects.isNull(chapter)) {
            throw new ChapterNotFoundException("Chapter not found with id: " + chapterId);
        }

        if (!chapter.getCourse().getId().equals(course.getId())) {
            throw new ChapterNotFoundException("Chapter does not belong to the specified course");
        }

        return chapter;
    }
}
