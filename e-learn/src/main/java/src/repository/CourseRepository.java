package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import src.entity.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c WHERE c.id = :id")
    Course getCourseById(@Param("id") Long id);

}
