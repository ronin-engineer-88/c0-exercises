package src.exception.LessonException;

public class LessonNotFoundException extends RuntimeException{
    public LessonNotFoundException(String message) {
        super(message);
    }
}
