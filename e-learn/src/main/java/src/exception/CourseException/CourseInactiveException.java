package src.exception.CourseException;

import src.exception.AppException;

public class CourseInactiveException extends AppException {
    public CourseInactiveException(String message) {
        super(message);
    }
}
