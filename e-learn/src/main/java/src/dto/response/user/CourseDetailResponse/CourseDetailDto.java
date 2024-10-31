package src.dto.response.user.CourseDetailResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class CourseDetailDto {

    private String name;

    private String description;

    private String status;

    private List<ChapterDetailDto> chapters;

    private TeacherDetailDto teacher;

    private Integer numChapter;

    private Integer numLesson;

    public CourseDetailDto(String name, String description, String status, List<ChapterDetailDto> chapters, TeacherDetailDto teacher) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.chapters = chapters;
        this.teacher = teacher;
        this.numChapter = chapters.size();
        this.numLesson = 0;
        for(int i = 0; i < chapters.size(); i++) {
            this.numLesson += chapters.get(0).lessons.size();
        }
    }
}
