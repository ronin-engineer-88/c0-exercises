package src.exception.TeacherException;

import src.exception.AppException;

public class TeacherNotFoundException extends AppException {
    public TeacherNotFoundException(String message) {
        super(message);
    }
}
