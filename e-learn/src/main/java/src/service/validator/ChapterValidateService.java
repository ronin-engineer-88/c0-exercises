package src.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.entity.Chapter;
import src.exception.ChapterException.ChapterNotFoundException;
import src.repository.ChapterRepository;

@Service
public class ChapterValidateService {

    private final ChapterRepository chapterRepository;

    @Autowired
    public ChapterValidateService(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    public Chapter validateChapterExist(Long chapterId) {
        return chapterRepository.getChapterById(chapterId)
                .orElseThrow(() -> new ChapterNotFoundException("Not found course with id: " + chapterId));
    }

}
