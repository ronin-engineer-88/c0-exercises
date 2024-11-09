package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import src.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    void deleteByStatus(String status);

}
