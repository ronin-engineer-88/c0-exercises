package src.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import src.entity.Teacher;

import java.util.Date;
import java.time.LocalDate;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Modifying
    void deleteByStatus(String status);

    @Query("SELECT t FROM Teacher t WHERE t.id = :id")
    Teacher getTeacherById(@Param("id") Long id);

    boolean existsByUsername(String username);

    @Query("SELECT t FROM Teacher t " +
            "WHERE (:username IS NULL OR t.username LIKE CONCAT('%', :username, '%')) " +
            "AND (:name IS NULL OR t.name LIKE CONCAT('%', :name, '%')) " +
            "AND (:status IS NULL OR t.status = :status) " +
            "AND (:createdDateFrom IS NULL OR t.createdDate >= :createdDateFrom) " +
            "AND (:createdDateTo IS NULL OR t.createdDate <= :createdDateTo)")
    Page<Teacher> findTeachers(@Param("username") String username,
                               @Param("name") String name,
                               @Param("status") String status,
                               @Param("createdDateFrom") Date createdDateFrom,
                               @Param("createdDateTo") Date createdDateTo,
                               Pageable pageable);

}
