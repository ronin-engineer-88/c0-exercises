package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import src.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u " +
            "FROM User u " +
            "WHERE u.id = :id")
    Optional<User> getUserById(@Param("id") Long id);
}
