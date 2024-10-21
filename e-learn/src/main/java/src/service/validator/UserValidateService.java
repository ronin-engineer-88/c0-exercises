package src.service.validator;

import org.springframework.stereotype.Service;
import src.constant.ConfigConstant;


@Service
public class UserValidateService {
    public void validateStatusRequest(String status) {
        if(!status.equals(ConfigConstant.ACTIVE.getValue())
        && !status.equals(ConfigConstant.INACTIVE.getValue()))
            throw new IllegalArgumentException("Status must be active or inactive!");
    }

}
