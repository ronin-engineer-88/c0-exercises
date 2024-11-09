package src.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import src.entity.Course;

import java.util.Date;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Modifying
    void deleteByStatus(String status);

    @Query("SELECT c FROM Course c WHERE c.id = :id")
    Course getCourseById(@Param("id") Long id);

    @Query("SELECT c FROM Course c " +
            "LEFT JOIN c.userCourses sc " +
            "WHERE (:name IS NULL OR c.name LIKE CONCAT('%', :name, '%')) " +
            "AND (:status IS NULL OR c.status = :status) " +
            "AND (:teacherName IS NULL OR c.teacher.name = :teacherName) " +
            "AND (:createdDateFrom IS NULL OR c.createdDate >= :createdDateFrom) " +
            "AND (:createdDateTo IS NULL OR c.createdDate <= :createdDateTo)")
    Page<Course> findCourses(@Param("name") String name,
                                        @Param("status") String status,
                                        @Param("teacherName") String teacherName,
                                        @Param("createdDateFrom") Date createdDateFrom,
                                        @Param("createdDateTo") Date createdDateTo,
                                        Pageable pageable);
}
