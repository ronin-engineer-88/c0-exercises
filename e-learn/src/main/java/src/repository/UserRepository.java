package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import src.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    void deleteByStatus(String status);
}
