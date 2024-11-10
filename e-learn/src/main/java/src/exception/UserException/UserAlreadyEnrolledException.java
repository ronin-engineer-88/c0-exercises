package src.exception.UserException;

import src.exception.AppException;

public class UserAlreadyEnrolledException extends AppException {
    public UserAlreadyEnrolledException(String message) {
        super(message);
    }
}
