package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import src.entity.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {

}
