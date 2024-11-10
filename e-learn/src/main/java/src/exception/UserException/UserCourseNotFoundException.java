package src.exception.UserException;

import src.exception.AppException;

public class UserCourseNotFoundException extends AppException {
    public UserCourseNotFoundException(String message) {
        super(message);
    }
}
