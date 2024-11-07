package src.exception.LessonException;

import src.exception.AppException;

public class NoLessonInCourseException extends AppException {
    public NoLessonInCourseException(String message) {
        super(message);
    }
}
