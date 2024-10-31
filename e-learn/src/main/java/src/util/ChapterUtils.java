package src.util;

import src.dto.response.user.CourseDetailResponse.ChapterDetailDto;
import src.dto.response.user.CourseDetailResponse.LessonDetailDto;
import src.entity.Chapter;

import java.util.List;
import java.util.stream.Collectors;

public class ChapterUtils {

    public static ChapterDetailDto convertToDetailDto(Chapter chapter) {

        ChapterDetailDto chapterDto = new ChapterDetailDto();
        chapterDto.setName(chapter.getName());
        chapterDto.setDescription(chapter.getDescription());
        chapterDto.setOrder(chapter.getOrder());
        List<LessonDetailDto> lessons = chapter.getLessons().stream()
                .map(LessonUtils::convertToDetailDto)
                .collect(Collectors.toList());
        chapterDto.setLessons(lessons);


        return chapterDto;
    }
}
