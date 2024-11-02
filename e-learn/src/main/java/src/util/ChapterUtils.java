package src.util;

import org.springframework.beans.BeanUtils;
import src.dto.response.admin.ChapterResponseDto;
import src.entity.Chapter;

public class ChapterUtils {

    public static ChapterResponseDto convertToResponseDto(Chapter chapter) {

        ChapterResponseDto chapterResponseDto = new ChapterResponseDto();
        BeanUtils.copyProperties(chapter, chapterResponseDto);
        chapterResponseDto.setCreatedDate(DateUtils.dateTimeToString(chapter.getCreatedDate()));
        chapterResponseDto.setUpdatedDate(
                chapter.getUpdatedDate() != null ? DateUtils.dateTimeToString(chapter.getUpdatedDate()) : null
        );

        return chapterResponseDto;
    }

}
