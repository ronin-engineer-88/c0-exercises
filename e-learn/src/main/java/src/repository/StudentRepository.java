package src.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import src.entity.Student;

import java.time.LocalDate;


public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.username = :username")
    Student findStudentByUsername(@Param("username") String username);

    @Query("SELECT s FROM Student s WHERE s.id = :id")
    Student getStudentById(@Param("id") Long id);

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
}
