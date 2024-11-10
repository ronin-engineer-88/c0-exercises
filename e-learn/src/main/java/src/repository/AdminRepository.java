package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import src.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query("SELECT a " +
            "FROM Admin a " +
            "WHERE a.username = :username " +
            "AND a.status = 'active' ")
    Admin findActiveAdminByUsername(@Param("username") String username);

    @Modifying
    void deleteByStatus(String status);

}
