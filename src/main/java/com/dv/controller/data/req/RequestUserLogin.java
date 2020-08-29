package com.dv.controller.data.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RequestUserLogin {
    @NotBlank(message = "Login is mandatory")
    private String login;
    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Password length should be more then 6 characters")
    private String pass;
}
