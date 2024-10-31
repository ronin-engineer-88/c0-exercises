package src.entity.CompositeKey;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseLessonId implements Serializable {

    private StudentCourseId studentCourseId;

    private Long lessonId;

}
