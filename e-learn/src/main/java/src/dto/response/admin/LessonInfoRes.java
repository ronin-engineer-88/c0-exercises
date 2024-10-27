package src.dto.response.admin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class LessonInfoRes {

    private Long courseId;

    private String courseName;

    private String courseDescription;

    private String courseStatus;

    private Long chapterId;

    private String chapterName;

    private String chapterDescription;

    private String chapterStatus;

    private Integer chapterOrder;

    private Long lessonId;

    private String lessonName;

    private String lessonDescription;

    private String lessonStatus;

    private String lessonType;

    private String lessonUrl;

    private Integer lessonOrder;

    private Date createdDate;

    private Date updatedDate;

    private Integer numUserCompleted;

    private Integer numUserInProgress;


}
