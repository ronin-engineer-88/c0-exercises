package src.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import src.dto.response.admin.CourseResponseDto;
import src.entity.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c WHERE c.id = :id")
    Course getCourseById(@Param("id") Long id);

    @Query("SELECT c FROM Course c " +
            "LEFT JOIN c.studentCourses sc " +
            "WHERE (:name IS NULL OR c.name LIKE %:name%) " +
            "AND (:status IS NULL OR c.status = :status) " +
            "AND (:teacherName IS NULL OR c.teacher.name = :teacherName) " +
            "AND (:createdDateFrom IS NULL OR c.createdDate >= :createdDateFrom) " +
            "AND (:createdDateTo IS NULL OR c.createdDate <= :createdDateTo) " +
            "AND (:ratingFrom IS NULL OR (SELECT AVG(sc.rating) FROM StudentCourse sc WHERE sc.course.id = c.id) >= :ratingFrom) " +
            "AND (:ratingTo IS NULL OR (SELECT AVG(sc.rating) FROM StudentCourse sc WHERE sc.course.id = c.id) <= :ratingTo)")
    Page<Course> findCourses(@Param("name") String name,
                                        @Param("status") String status,
                                        @Param("teacherName") String teacherName,
                                        @Param("createdDateFrom") LocalDate createdDateFrom,
                                        @Param("createdDateTo") LocalDate createdDateTo,
                                        @Param("ratingFrom") Double ratingFrom,
                                        @Param("ratingTo") Double ratingTo,
                                        Pageable pageable);
}
