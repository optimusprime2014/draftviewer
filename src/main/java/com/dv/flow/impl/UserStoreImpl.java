package com.dv.flow.impl;

import com.dv.flow.UserStore;
import com.dv.controller.model.Response;
import com.dv.controller.model.ResponseStatus;
import com.dv.flow.util.ConvertService;
import com.dv.controller.model.request.User;
import com.dv.controller.model.request.UserLogin;
import com.dv.db.DBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class UserStoreImpl implements UserStore {

    @Autowired
    ConvertService convertService;

    @Autowired
    DBService dbService;

    @Override
    public Response signUpUser(User user) {
        Response response = Response.builder().build();

        //check available login
        Optional<com.dv.db.model.User> optionalUser = dbService.getUserService().finUserByLogin(user.getLogin());
        if (optionalUser.isPresent()) {
            return response
                    .setStatus(ResponseStatus.REGISTER_FAILED)
                    .setMessage(String.join(" ", "Login", user.getLogin(), "is present"));
        }

        //check available email
        optionalUser = dbService.getUserService().findUserByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            return response
                    .setStatus(ResponseStatus.REGISTER_FAILED)
                    .setMessage(String.join(" ", "Email", user.getLogin(), "is present"));
        }

        //check pass & confirm
        if (!user.getPass().equals(user.getConfirmPass())) {
            return response
                    .setStatus(ResponseStatus.REGISTER_FAILED)
                    .setMessage("Confirm password wrong");
        }

        //save new user
        com.dv.db.model.User newUser = new com.dv.db.model.User()
                .setId(UUID.randomUUID())
                .setLogin(user.getLogin())
                .setPass(user.getPass())
                .setEmail(user.getEmail());
        return response
                .setStatus(ResponseStatus.OK)
                .setMessage(String.join(" ", "User", user.getLogin(), "saved"))
                //TODO .setData(dbService.getUserService().saveUser(newUser));
                .setData(newUser);
    }

    @Override
    public Response loginUser(UserLogin user) {
        Response response = Response.builder().build();

        //check available login
        Optional<com.dv.db.model.User> optionalUser = dbService.getUserService().finUserByLogin(user.getLogin());
        if (!optionalUser.isPresent()) {
            return response
                    .setStatus(ResponseStatus.LOGIN_FAILED)
                    .setMessage("Login is wrong");
        }

        //check login & pass
        optionalUser = dbService.getUserService().findUserByLoginAndPass(user.getLogin(), user.getPass());
        if (!optionalUser.isPresent()) {
            return response
                    .setStatus(ResponseStatus.LOGIN_FAILED)
                    .setMessage("Password is wrong");
        }

        return response
                .setStatus(ResponseStatus.OK)
                .setMessage(String.join(" ", "User", optionalUser.get().getLogin(), "logged"))
                .setData(optionalUser.get());
    }

    @Override
    public Response infoUser(String userId) {
        Response response = Response.builder().build();

        //check available userId
        Optional<com.dv.db.model.User> optionalUser = dbService.getUserService().findUserById(userId);
        if (!optionalUser.isPresent()) {
            return response
                    .setStatus(ResponseStatus.SERVER_ERROR)
                    .setMessage("User is wrong");
        }

        return response
                .setStatus(ResponseStatus.OK)
                .setMessage(String.join(" ", "Info for user", optionalUser.get().getLogin(), "prepared"))
                        .setData(null);//TODO impl: prepare info for users...
    }
}