package src.exception.LessonException;

import src.exception.AppException;

public class LessonNotFoundException extends AppException {
    public LessonNotFoundException(String message) {
        super(message);
    }
}
