package src.service.validator;

import org.springframework.stereotype.Service;
import src.entity.Admin;
import src.exception.UserException.InvalidPasswordException;


@Service
public class RequestValidateService {

    public void checkLoginPassword(Admin admin, String password) {
        if(!admin.getPassword().equals(password))
            throw new InvalidPasswordException("Incorrect password!");
    }

}
