package src.exception.UserException;

import src.exception.AppException;

public class UserInactiveException extends AppException {
    public UserInactiveException(String message) {
        super(message);
    }
}
