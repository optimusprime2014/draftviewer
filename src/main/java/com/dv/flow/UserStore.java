package com.dv.flow;

import com.dv.controller.model.Response;
import com.dv.controller.model.request.User;
import com.dv.controller.model.request.UserLogin;

public interface UserStore {
    Response signUpUser(User user);
    Response loginUser(UserLogin user);
    Response infoUser(String userId);
}
