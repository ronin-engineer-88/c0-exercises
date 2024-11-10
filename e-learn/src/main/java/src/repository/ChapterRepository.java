package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import src.entity.Chapter;


public interface ChapterRepository extends JpaRepository<Chapter, Long> {

    @Query("SELECT ch " +
            "FROM Chapter ch " +
            "WHERE ch.id = :id")
    Chapter getChapterById(@Param("id") Long id);

}
