package src.exception.AdminException;

import src.exception.AppException;

public class AdminNotFoundException extends AppException {
    public AdminNotFoundException(String message) {
        super(message);
    }
}
