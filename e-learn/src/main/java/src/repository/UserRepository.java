package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import src.entity.Student;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s " +
            "FROM Student s " +
            "WHERE s.id = :id")
    Optional<Student> getStudentById(@Param("id") Long id);
}
