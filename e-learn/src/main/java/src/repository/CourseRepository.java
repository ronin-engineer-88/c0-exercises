package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import src.entity.Course;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT c " +
            "FROM Course c " +
            "WHERE c.id = :id")
    Optional<Course> getCourseById(@Param("id") Long id);
}
