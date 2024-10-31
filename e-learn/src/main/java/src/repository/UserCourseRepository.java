package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import src.entity.Course;
import src.entity.Student;
import src.entity.StudentCourse;

public interface UserCourseRepository extends JpaRepository<StudentCourse, Long> {

    @Query("SELECT sc FROM StudentCourse sc " +
            "WHERE sc.student = :user " +
            "AND sc.course = :course")
    StudentCourse getStudentCourseById(
            @Param("user") Student user,
            @Param("course") Course course
    );
}
