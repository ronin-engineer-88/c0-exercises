package src.exception.CourseException;

import src.exception.AppException;

public class CourseNotFoundException extends AppException {
    public CourseNotFoundException(String message) {
        super(message);
    }
}
