package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import src.entity.Teacher;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT t " +
            "FROM Teacher t " +
            "WHERE t.id = :id")
    Optional<Teacher> getTeacherById(@Param("id") Long id);
}
