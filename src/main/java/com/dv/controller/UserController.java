package com.dv.controller;

import com.dv.controller.data.resp.Response;
import com.dv.controller.data.req.RequestUser;
import com.dv.controller.data.req.RequestUserLogin;
import com.dv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/users", produces = "application/json; charset=UTF-8")
public class UserController {

    @Autowired
    UserService userStore;

    @PostMapping
    public Response signup(@Valid @RequestBody RequestUser requestUser) {
        return userStore.signup(requestUser);
    }

    @PostMapping(value = "/user")
    public Response login(@Valid @RequestBody RequestUserLogin requestUserLogin) {
        return userStore.login(requestUserLogin);
    }

    @GetMapping(value = "/user")
    public Response info(@RequestParam String id) {
        return userStore.getInfo(id);
    }
}
