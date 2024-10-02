package src.controller;

import org.springframework.web.bind.annotation.*;
import src.constant.UrlConstant;
import src.dto.request.UserLoginReq;
import src.dto.request.UserSearchReq;
import src.dto.response.UserSearchRes;

@RestController
@RequestMapping(UrlConstant.API_V1)
public class UserController {

    @PostMapping(UrlConstant.USER_LOGIN)
    public Object login(@RequestBody UserLoginReq req) {
        return req;
    }

    @DeleteMapping(UrlConstant.DELETE_USERS)
    public Object softDeleteUser(@PathVariable("user_id") Long userId) {
        return userId;
    }

    @GetMapping(UrlConstant.GET_USERS)
    public Object getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "created_date") String sort,
            @RequestBody UserSearchReq req) {

        UserSearchRes res = new UserSearchRes();
        res.setSort(sort);
        res.setPage(page);
        res.setPageSize(pageSize);
        res.setUsername(req.getUsername());
        res.setName(req.getName());
        res.setStatus(req.getStatus());
        res.setCreatedDateFrom(req.getCreatedDateFrom());
        res.setCreatedDateTo(req.getCreatedDateTo());

        return res;
    }
}