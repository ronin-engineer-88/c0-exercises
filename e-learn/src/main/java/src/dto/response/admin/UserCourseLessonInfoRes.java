package src.dto.response.admin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class UserCourseLessonInfoRes {

    private Long userId;

    private String userName;

    private String userStatus;

    private Integer userAge;

    private String userUsername;

    private String userPassword;

    private Long courseId;

    private String courseName;

    private String courseDescription;

    private String courseStatus;

    private Long lessonId;

    private String lessonName;

    private String lessonDescription;

    private String lessonStatus;

    private String lessonType;

    private String lessonUrl;

    private Integer lessonOrder;

    private Integer numProcessingLesson;

    private Integer numCompletedLesson;
}
