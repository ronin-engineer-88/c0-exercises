package src.util;

import org.springframework.beans.BeanUtils;
import src.dto.response.user.CourseRegisterSearchResponse;
import src.dto.response.user.DetailResponse.ChapterResponseDto;
import src.dto.response.user.DetailResponse.CourseResponseDto;
import src.entity.Course;
import src.entity.User;
import src.entity.UserCourse;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
public class CourseUtils {

    public static CourseResponseDto convertToDto(Course course) {

        List<ChapterResponseDto> chapters = course.getChapters().stream()
                .map(ChapterUtils::convertToDto)
                .collect(Collectors.toList());

        CourseResponseDto courseDto = new CourseResponseDto(
                course.getName(),
                course.getDescription(),
                course.getStatus(),
                chapters,
                TeacherUtils.convertToDto(course.getTeacher())
        );
        courseDto.setCreatedDate(DateUtils.dateTimeToString(course.getCreatedDate()));
        courseDto.setUpdatedDate(
                course.getUpdatedDate() != null ? DateUtils.dateTimeToString(course.getUpdatedDate()) : null);

        return courseDto;
    }

    public static CourseRegisterSearchResponse convertToDTO(Long userId, Course course) {

        CourseRegisterSearchResponse courseRegisterSearchResponse
                = new CourseRegisterSearchResponse();

        BeanUtils.copyProperties(course, courseRegisterSearchResponse);
        courseRegisterSearchResponse.setTeacherName(course.getTeacher().getName());
        courseRegisterSearchResponse.setCreatedDate(DateUtils.dateTimeToString(course.getCreatedDate()));
        courseRegisterSearchResponse.setUpdatedDate(
                course.getUpdatedDate() != null ? DateUtils.dateTimeToString(course.getUpdatedDate()) : null);
        courseRegisterSearchResponse.setNumChapters(course.getChapters().size());
        courseRegisterSearchResponse.setNumLessons(
                course.getChapters().stream()
                        .mapToInt(ch -> ch.getLessons().size())
                        .sum()
        );
        courseRegisterSearchResponse.setRate(
                course.getUserCourses().stream()
                        .filter(userCourse -> Objects.equals(userCourse.getUser().getId(), userId))
                        .map(UserCourse::getRating)
                        .findFirst()
                        .orElse(null)
        );


        return courseRegisterSearchResponse;

    }
}
