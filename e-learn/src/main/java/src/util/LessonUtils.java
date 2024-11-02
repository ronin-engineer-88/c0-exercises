package src.util;

import org.springframework.beans.BeanUtils;
import src.dto.response.admin.LessonResDto;
import src.entity.Lesson;


public class LessonUtils {

    public static LessonResDto convertToLessonResponseDto(Lesson lesson) {
        LessonResDto lessonResponseDto = new LessonResDto();
        BeanUtils.copyProperties(lesson, lessonResponseDto);
        lessonResponseDto.setCreatedDate(DateUtils.dateTimeToString(lesson.getCreatedDate()));
        lessonResponseDto.setUpdatedDate(
                lesson.getUpdatedDate() != null ? DateUtils.dateTimeToString(lesson.getUpdatedDate()) : null
        );

        return lessonResponseDto;
    }

}
