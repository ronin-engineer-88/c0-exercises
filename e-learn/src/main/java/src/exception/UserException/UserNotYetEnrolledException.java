package src.exception.UserException;

import src.exception.AppException;

public class UserNotYetEnrolledException extends AppException {
    public UserNotYetEnrolledException(String message) {
        super(message);
    }
}
