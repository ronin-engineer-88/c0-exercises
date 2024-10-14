package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import src.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
