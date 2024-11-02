package src.util;

import org.springframework.beans.BeanUtils;
import src.dto.response.admin.CourseResponseDto;
import src.entity.Course;

public class CourseUtils {

    public static CourseResponseDto convertToCourseResponseDto(Course course) {
        CourseResponseDto courseResponseDto = new CourseResponseDto();
        BeanUtils.copyProperties(course, courseResponseDto);
        courseResponseDto.setCreatedDate(DateUtils.dateTimeToString(course.getCreatedDate()));
        courseResponseDto.setUpdatedDate(
                course.getUpdatedDate() != null ? DateUtils.dateTimeToString(course.getUpdatedDate()) : null
        );

        return courseResponseDto;
    }

}
