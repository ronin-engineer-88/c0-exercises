//package src.repository;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import src.entity.Teacher;
//
//import java.time.LocalDate;
//
//public interface TeacherRepository extends JpaRepository<Teacher, Long> {
//
//    @Query("SELECT t FROM Teacher t WHERE t.id = :id")
//    Teacher getTeacherById(@Param("id") Long id);
//
//    boolean existsByUsername(String username);
//
//    @Query("SELECT t FROM Teacher t " +
//            "WHERE (:username IS NULL OR t.username LIKE %:username%) " +
//            "AND (:name IS NULL OR t.name LIKE %:name%) " +
//            "AND (:status IS NULL OR t.status = :status) " +
//            "AND (:createdDateFrom IS NULL OR t.createdDate >= :createdDateFrom) " +
//            "AND (:createdDateTo IS NULL OR t.createdDate <= :createdDateTo)")
//    Page<Teacher> findTeachers(@Param("username") String username,
//                               @Param("name") String name,
//                               @Param("status") String status,
//                               @Param("createdDateFrom") LocalDate createdDateFrom,
//                               @Param("createdDateTo") LocalDate createdDateTo,
//                               Pageable pageable);
//}
