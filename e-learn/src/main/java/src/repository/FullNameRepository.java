package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import src.entity.FullName;

public interface FullNameRepository extends JpaRepository<FullName, Long> {

    @Modifying
    void deleteByStatus(String status);
}
