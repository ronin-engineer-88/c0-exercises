package src.exception.ChapterException;

import src.exception.AppException;

public class ChapterNotFoundException extends AppException {
    public ChapterNotFoundException(String message) {
        super(message);
    }
}
