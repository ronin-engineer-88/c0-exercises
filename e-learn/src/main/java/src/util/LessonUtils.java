package src.util;

import src.dto.response.user.DetailResponse.LessonResponseDto;
import src.entity.Lesson;

public class LessonUtils {
    public static class User {
        public static LessonResponseDto convertToResponseDto(Lesson lesson) {

            LessonResponseDto lessonDto = new LessonResponseDto();
            lessonDto.setName(lesson.getName());
            lessonDto.setDescription(lesson.getDescription());
            lessonDto.setType(lesson.getType());
            lessonDto.setUrl(lesson.getUrl());
            lessonDto.setOrder(lesson.getOrder());

            return lessonDto;
        }
    }
}
