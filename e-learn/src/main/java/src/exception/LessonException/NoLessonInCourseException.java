package src.exception.LessonException;

public class NoLessonInCourseException extends RuntimeException{
    public NoLessonInCourseException(String message) {
        super(message);
    }
}