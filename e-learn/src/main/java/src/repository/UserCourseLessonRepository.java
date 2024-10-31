package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import src.entity.Lesson;
import src.entity.StudentCourse;
import src.entity.StudentCourseLesson;

import java.util.Optional;

public interface UserCourseLessonRepository extends JpaRepository<StudentCourseLesson, Long> {

    @Query("SELECT scl " +
            "FROM StudentCourseLesson scl " +
            "WHERE scl.studentCourse = :sc " +
            "AND scl.lesson = :lesson")
    Optional<StudentCourseLesson> getStudentCourseLesson(StudentCourse sc, Lesson lesson);

}
