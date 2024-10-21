package src.exception;

public class UserCourseNotFoundException extends RuntimeException{
    public UserCourseNotFoundException(String message) {
        super(message);
    }
}
