package src.service.validator;

import org.springframework.stereotype.Service;
import src.constant.ConfigConstant;
import src.constant.StatusConstant;

@Service
public class RequestValidateService {
    public void checkConfigStatusRequest(Integer status) {
        if(status != ConfigConstant.ACTIVE.getCode()
                && status != ConfigConstant.INACTIVE.getCode())
            throw new IllegalArgumentException("Status must be active or inactive!");
    }

    public void checkStatusRequest(String status) {
        if(status != StatusConstant.START.getValue()
            && status != StatusConstant.PROCESSING.getValue()
            && status != StatusConstant.DONE.getValue())
            throw new IllegalArgumentException("Status must be START, PROCESSING or DONE!");
    }
}
