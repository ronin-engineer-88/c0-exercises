package src.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import src.entity.Chapter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {

    Chapter getChapterById(Long chapterId);

    List<Chapter> findByCourseIdAndStatus(Long courseId, String status); // Search chapter status 'active'

    @Query("SELECT ch FROM Chapter ch " +
            "WHERE (:name IS NULL OR ch.name LIKE CONCAT('%', :name, '%')) " +
            "AND (:status IS NULL OR ch.status = :status) " +
            "AND (:createdDateFrom IS NULL OR ch.createdDate >= :createdDateFrom) " +
            "AND (:createdDateTo IS NULL OR ch.createdDate <= :createdDateTo)")
    Page<Chapter> findChapter(@Param("name") String name,
                              @Param("status") String status,
                              @Param("createdDateFrom") Date createdDateFrom,
                              @Param("createdDateTo") Date createdDateTo,
                              Pageable pageable);
}
