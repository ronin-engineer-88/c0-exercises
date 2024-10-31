package src.exception.UserException;

public class UserNotYetEnrolledException extends RuntimeException {
    public UserNotYetEnrolledException(String message) {
        super(message);
    }
}
