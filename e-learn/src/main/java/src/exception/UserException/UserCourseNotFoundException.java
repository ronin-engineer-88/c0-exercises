package src.exception.UserException;

public class UserCourseNotFoundException extends RuntimeException{
    public UserCourseNotFoundException(String message) {
        super(message);
    }
}
