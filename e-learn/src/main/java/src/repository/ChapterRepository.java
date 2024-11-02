package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import src.entity.Chapter;

import java.util.Optional;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {

    @Query("SELECT ch " +
            "FROM Chapter ch " +
            "WHERE ch.id = :id")
    Optional<Chapter> getChapterById(@Param("id") Long id);

}
