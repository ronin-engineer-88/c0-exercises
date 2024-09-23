package src.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import src.constant.UrlConstant;
import src.dto.request.UserLoginReq;

@RestController
public class UserController {

    @PostMapping(UrlConstant.USER_LOGIN)
    public Object login(@RequestBody UserLoginReq req) {
        return req;
    }
}