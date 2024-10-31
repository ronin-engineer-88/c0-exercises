package src.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import src.entity.Course;
import src.entity.Student;

import java.time.LocalDate;
import java.util.Optional;


public interface UserRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s " +
            "FROM Student s " +
            "WHERE s.username = :username")
    Optional<Student> findUserByUsername(@Param("username") String username);

    @Query("SELECT s " +
            "FROM Student s " +
            "WHERE s.username = :username " +
            "AND s.status = 'active'")
    Optional<Student> findActiveUserByUsername(@Param("username") String username);

    @Query("SELECT s " +
            "FROM Student s " +
            "WHERE s.id = :id")
    Optional<Student> getStudentById(@Param("id") Long id);

    @Query("SELECT s FROM Student s " +
            "WHERE (:name IS NULL OR s.name LIKE %:name%) " +
            "AND (:age IS NULL OR s.age = :age) " +
            "AND (:username IS NULL OR s.username = :username) " +
            "AND (:status IS NULL OR s.status = :status) " +
            "AND (:createdDateFrom IS NULL OR s.createdDate >= :createdDateFrom) " +
            "AND (:createdDateTo IS NULL OR s.createdDate <= :createdDateTo)")
    Page<Student> findStudents(
            @Param("name") String name,
            @Param("age") Integer age,
            @Param("username") String username,
            @Param("status") String status,
            @Param("createdDateFrom") LocalDate createdDateFrom,
            @Param("createdDateTo") LocalDate createdDateTo,
            Pageable pageable
    );

    @Query("SELECT c " +
            "FROM Course c " +
            "INNER JOIN StudentCourse sc ON c.id = sc.studentCourseId.courseId " +
            "WHERE sc.studentCourseId.studentId = :userId " +
            "AND (:name IS NULL OR c.name LIKE %:name%) " +
            "AND (:status IS NULL OR c.status = :status) " +
            "AND (:teacherName IS NULL OR c.teacher.name = :teacherName) " +
            "AND (:createdDateFrom IS NULL OR c.createdDate >= :createdDateFrom) " +
            "AND (:createdDateTo IS NULL OR c.createdDate <= :createdDateTo)" +
            "AND (:ratingFrom IS NULL OR (" +
            "                             SELECT AVG(sc.rating) " +
            "                             FROM StudentCourse sc " +
            "                             WHERE sc.studentCourseId.courseId = c.id" +
            "                            ) >= :ratingFrom) " +
            "AND (:ratingTo IS NULL OR (" +
            "                           SELECT AVG(sc.rating) " +
            "                           FROM StudentCourse sc " +
            "                           WHERE sc.studentCourseId.courseId = c.id" +
            "                           ) <= :ratingTo)" +
            "AND (:numLessons IS NULL OR (" +
            "                             SELECT COUNT(l) " +
            "                             FROM Lesson l " +
            "                             WHERE l.chapter.id IN (" +
            "                                                    SELECT ch.id " +
            "                                                    FROM Chapter ch " +
            "                                                    WHERE ch.course.id = c.id" +
            "                                                   )" +
            "                             ) = :numLessons)")
    Page<Course> findRegisterCourses(
            @Param("userId") Long userId,
            @Param("name") String name,
            @Param("status") String status,
            @Param("teacherName") String teacherName,
            @Param("createdDateFrom") LocalDate createdDateFrom,
            @Param("createdDateTo") LocalDate createdDateTo,
            @Param("ratingFrom") Double ratingFrom,
            @Param("ratingTo") Double ratingTo,
            @Param("numLessons") Integer numLessons,
            Pageable pageable
    );

}
