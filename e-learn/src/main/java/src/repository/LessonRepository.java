package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import src.entity.Lesson;

import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    @Query("SELECT l " +
            "FROM Lesson l " +
            "WHERE l.id = :id")
    Optional<Lesson> getLessonById(@Param("id") Long id);
}