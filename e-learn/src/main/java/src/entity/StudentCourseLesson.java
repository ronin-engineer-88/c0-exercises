package src.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import src.entity.CompositeKey.StudentCourseLessonId;

import java.time.LocalDateTime;

@Entity
@Table(name = "student_course_lesson")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseLesson {

    @EmbeddedId
    private StudentCourseLessonId id;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @MapsId("studentCourseId")
    @JoinColumns({
            @JoinColumn(name = "user_course_user_id", referencedColumnName = "student_id"),
            @JoinColumn(name = "user_course_course_id", referencedColumnName = "course_id")
    })
    private StudentCourse studentCourse;

    @ManyToOne
    @MapsId("lessonId")
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
}