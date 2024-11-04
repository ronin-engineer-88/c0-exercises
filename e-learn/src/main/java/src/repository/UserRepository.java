package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import src.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT s " +
            "FROM User s " +
            "WHERE s.id = :id")
    Optional<User> getStudentById(@Param("id") Long id);
}
