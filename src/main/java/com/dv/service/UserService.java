package com.dv.service;

import com.dv.controller.data.req.RequestUser;
import com.dv.controller.data.resp.Response;
import com.dv.controller.data.resp.ResponseStatus;
import com.dv.db.model.User;
import com.dv.db.repo.ComboRepository;
import com.dv.service.util.ConvertUtils;
import com.dv.controller.data.req.RequestUserLogin;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private ConvertUtils convertUtils;

    @Autowired
    private ComboRepository repo;

    public Response signup(RequestUser requestUser) {
        Response response = Response.builder().build();

        //check available login
        Optional<User> optionalUser = repo.getUserRepo().findByLogin(requestUser.getLogin());
        if (optionalUser.isPresent()) {
            return response
                    .setStatus(ResponseStatus.REGISTER_FAILED)
                    .setMessage(String.join(" ", "Login [", requestUser.getLogin(), "] is present"));
        }

        //check available email
        optionalUser = repo.getUserRepo().findByEmail(requestUser.getEmail());
        if (optionalUser.isPresent()) {
            return response
                    .setStatus(ResponseStatus.REGISTER_FAILED)
                    .setMessage(String.join(" ", "Email [", requestUser.getLogin(), "] is present"));
        }

        //check pass & confirm
        if (!requestUser.getPass().equals(requestUser.getConfirmPass())) {
            return response
                    .setStatus(ResponseStatus.REGISTER_FAILED)
                    .setMessage("Confirmed password wrong");
        }

        //save new user
        User savedUser = repo.getUserRepo().save(
                new User(requestUser.getLogin(), requestUser.getPass(), requestUser.getEmail()));
        savedUser.setPass(Strings.EMPTY);
        savedUser.setProjects(null);

        return response
                .setStatus(ResponseStatus.OK)
                .setMessage(String.join(" ", "User [", requestUser.getLogin(), "] saved"))
                .setData(repo.getUserRepo().save(savedUser));
    }

    public Response login(RequestUserLogin user) {
        Response response = Response.builder().build();

        //check available login
        Optional<User> optionalUser = repo.getUserRepo().findByLogin(user.getLogin());
        if (!optionalUser.isPresent()) {
            return response
                    .setStatus(ResponseStatus.LOGIN_FAILED)
                    .setMessage("Login is wrong");
        }

        //check login & pass
        optionalUser = repo.getUserRepo().findByLoginAndPass(user.getLogin(), user.getPass());
        if (!optionalUser.isPresent()) {
            return response
                    .setStatus(ResponseStatus.LOGIN_FAILED)
                    .setMessage("Password is wrong");
        }

        User existUser = optionalUser.get();
        existUser.setProjects(null);
        return response
                .setStatus(ResponseStatus.OK)
                .setMessage(String.join(" ", "User [", existUser.getLogin(), "] logged"))
                .setData(existUser)
        ;
    }

    public Response getInfo(String userId) {
        Response response = Response.builder().build();

        //check available userId
        Optional<User> optionalUser = repo.getUserRepo().findById(UUID.fromString(userId));
        if (!optionalUser.isPresent()) {
            return response
                    .setStatus(ResponseStatus.SERVER_ERROR)
                    .setMessage("User is wrong");
        }

        return response
                .setStatus(ResponseStatus.OK)
                .setMessage(String.join(" ", "Info for user [", optionalUser.get().getLogin(), "] prepared"))
                .setData(convertUtils.getProjectInfos(repo.getProjectRepo().findAllByUser(optionalUser.get())));
    }
}