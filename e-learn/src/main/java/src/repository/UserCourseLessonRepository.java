package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import src.entity.CompositeKey.UserCourseLessonId;
import src.entity.Lesson;
import src.entity.UserCourse;
import src.entity.UserCourseLesson;

import java.util.List;
import java.util.Optional;

public interface UserCourseLessonRepository extends JpaRepository<UserCourseLesson, UserCourseLessonId> {

    @Query("SELECT ucl " +
            "FROM UserCourseLesson ucl " +
            "WHERE ucl.userCourse = :sc " +
            "AND ucl.lesson = :lesson")
    Optional<UserCourseLesson> getStudentCourseLesson(UserCourse sc, Lesson lesson);

    @Query("SELECT ucl " +
            "FROM UserCourseLesson ucl " +
            "WHERE ucl.userCourse = :uc")
    List<UserCourseLesson> getListStudentCourseLesson(UserCourse uc);

}
