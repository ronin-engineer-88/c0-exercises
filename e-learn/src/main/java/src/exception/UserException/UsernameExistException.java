package src.exception.UserException;

import src.exception.AppException;

public class UsernameExistException extends AppException {
    public UsernameExistException(String message) {
        super(message);
    }
}
