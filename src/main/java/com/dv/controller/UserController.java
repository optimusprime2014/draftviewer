package com.dv.controller;

import com.dv.controller.model.Response;
import com.dv.controller.model.request.User;
import com.dv.controller.model.request.UserLogin;
import com.dv.flow.impl.UserStoreImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/users", produces = "application/json; charset=UTF-8")
public class UserController {

    @Autowired
    UserStoreImpl userStore;

    @PostMapping
    public Response signup(@Valid @RequestBody User user) {
        return userStore.signUpUser(user);
    }

    @PostMapping(value = "/user")
    public Response login(@Valid @RequestBody UserLogin user) {
        return userStore.loginUser(user);
    }

    @PostMapping(value = "/{userId}")
    public Response info(@RequestParam String userId) {
        return userStore.infoUser(userId);
    }
}
