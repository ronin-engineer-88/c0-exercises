package src.exception.UserException;

import src.exception.AppException;

public class InvalidPasswordException extends AppException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}