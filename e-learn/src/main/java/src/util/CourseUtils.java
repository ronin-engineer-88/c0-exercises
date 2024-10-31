package src.util;

import src.dto.response.user.CourseDetailResponse.ChapterDetailDto;
import src.dto.response.user.CourseDetailResponse.CourseDetailDto;
import src.entity.Course;

import java.util.List;
import java.util.stream.Collectors;
public class CourseUtils {

    public static CourseDetailDto convertToDetailDto(Course course) {

        List<ChapterDetailDto> chapters = course.getChapters().stream()
                .map(ChapterUtils::convertToDetailDto)
                .collect(Collectors.toList());

        CourseDetailDto courseDto = new CourseDetailDto(
                course.getName(),
                course.getDescription(),
                course.getStatus(),
                chapters,
                TeacherUtils.convertToDetailDto(course.getTeacher())
        );

        return courseDto;
    }
}
