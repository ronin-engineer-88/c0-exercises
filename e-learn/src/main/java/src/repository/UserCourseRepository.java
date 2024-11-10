package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import src.entity.CompositeKey.UserCourseId;
import src.entity.Course;
import src.entity.User;
import src.entity.UserCourse;


public interface UserCourseRepository extends JpaRepository<UserCourse, UserCourseId> {

    @Query("SELECT uc FROM UserCourse uc " +
            "WHERE uc.user = :user " +
            "AND uc.course = :course")
    UserCourse getUserCourse(
            @Param("user") User user,
            @Param("course") Course course
    );
}