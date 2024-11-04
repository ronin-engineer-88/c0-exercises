package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import src.entity.FullName;
import src.entity.User;

public interface FullNameRepository extends JpaRepository <FullName, Long> {


}
