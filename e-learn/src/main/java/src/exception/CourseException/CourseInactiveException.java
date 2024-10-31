package src.exception.CourseException;

public class CourseInactiveException extends RuntimeException {
    public CourseInactiveException(String message) {
        super(message);
    }
}
