package src.util;

import src.dto.response.user.CourseDetailResponse.LessonDetailDto;
import src.entity.Lesson;

public class LessonUtils {

    public static LessonDetailDto convertToDetailDto(Lesson lesson) {

        LessonDetailDto lessonDto = new LessonDetailDto();
        lessonDto.setName(lesson.getName());
        lessonDto.setDescription(lesson.getDescription());
        lessonDto.setType(lesson.getType());
        lessonDto.setUrl(lesson.getUrl());
        lessonDto.setOrder(lesson.getOrder());

        return lessonDto;
    }
}
