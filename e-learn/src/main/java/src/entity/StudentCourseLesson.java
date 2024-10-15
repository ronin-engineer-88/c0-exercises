package src.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "student_course_lesson")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseLesson extends BaseEntity {

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "user_course_user_id", referencedColumnName = "student_id"),
            @JoinColumn(name = "user_course_course_id", referencedColumnName = "course_id")
    })
    private StudentCourse studentCourse;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @Column(name = "status")
    private String status;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
}
