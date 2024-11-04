package src.exception;

import java.util.Date;

public class AppException extends RuntimeException {
    private String message;
    private Date date;
    private String field;

    public AppException(String message) {
        super(message);
        this.message = message;
        date = new Date();
    }
}