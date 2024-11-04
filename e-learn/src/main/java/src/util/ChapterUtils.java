package src.util;

import src.dto.response.user.DetailResponse.ChapterResponseDto;
import src.dto.response.user.DetailResponse.LessonResponseDto;
import src.entity.Chapter;

import java.util.List;
import java.util.stream.Collectors;

public class ChapterUtils {
    public static class User {
        public static ChapterResponseDto convertToResponseDto(Chapter chapter) {

            ChapterResponseDto chapterDto = new ChapterResponseDto();
            chapterDto.setName(chapter.getName());
            chapterDto.setDescription(chapter.getDescription());
            chapterDto.setOrder(chapter.getOrder());
            List<LessonResponseDto> lessons = chapter.getLessons().stream()
                    .map(LessonUtils.User::convertToResponseDto)
                    .collect(Collectors.toList());
            chapterDto.setLessons(lessons);


            return chapterDto;
        }
    }
}
