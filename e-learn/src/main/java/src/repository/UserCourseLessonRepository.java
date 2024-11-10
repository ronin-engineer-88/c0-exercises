package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import src.entity.CompositeKey.UserCourseLessonId;
import src.entity.Lesson;
import src.entity.UserCourse;
import src.entity.UserCourseLesson;

import java.util.List;

public interface UserCourseLessonRepository extends JpaRepository<UserCourseLesson, UserCourseLessonId> {

    @Query("SELECT ucl " +
            "FROM UserCourseLesson ucl " +
            "WHERE ucl.userCourse = :uc " +
            "AND ucl.lesson = :lesson")
    UserCourseLesson getUserCourseLesson(UserCourse uc, Lesson lesson);

    @Query("SELECT ucl " +
            "FROM UserCourseLesson ucl " +
            "WHERE ucl.userCourse = :uc")
    List<UserCourseLesson> getListUserCourseLesson(UserCourse uc);

}
