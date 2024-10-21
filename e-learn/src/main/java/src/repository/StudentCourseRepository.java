package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import src.entity.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

    @Query("SELECT sc FROM StudentCourse sc " +
            "WHERE sc.student.id = :studentId " +
            "AND sc.course.id = :courseId")
    StudentCourse getStudentCourseById(
            @Param("studentId") Long studentId,
            @Param("courseId") Long courseId
    );
}
