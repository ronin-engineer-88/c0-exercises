package src.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import src.entity.UserCourseLesson;

public interface UserCourseLessonRepository extends JpaRepository<UserCourseLesson, Long> {

    @Modifying
    void deleteByStatus(String status);
}
