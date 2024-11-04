package src.service.validator;

import org.springframework.stereotype.Service;
import src.constant.ConfigConstant;
import src.constant.StatusConstant;
import src.entity.User;
import src.exception.UserException.InvalidPasswordException;

import java.util.Objects;

@Service
public class RequestValidateService {
    public void checkLoginPassword(User user, String password) {
        if(!user.getPassword().equals(password))
            throw new InvalidPasswordException("Incorrect password!");
    }

    public void checkConfigStatusRequest(Integer status) {
        if(status != ConfigConstant.ACTIVE.getCode()
                && status != ConfigConstant.INACTIVE.getCode())
            throw new IllegalArgumentException("Status must be active or inactive!");
    }

    public void checkStatusRequest(String status) {
        if(!Objects.equals(status, StatusConstant.START.getValue())
            && !Objects.equals(status, StatusConstant.PROCESSING.getValue())
            && !Objects.equals(status, StatusConstant.DONE.getValue()))
            throw new IllegalArgumentException("Status must be START, PROCESSING or DONE!");
    }
}
