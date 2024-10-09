package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import src.entity.Chapter;
import src.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
