package src.exception.UserException;

import src.exception.AppException;

public class UserNotFoundException extends AppException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
