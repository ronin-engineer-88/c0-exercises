package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import src.entity.UserCourse;

public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {

    @Modifying
    void deleteByStatus(String status);
}
