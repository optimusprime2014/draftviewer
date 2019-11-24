package com.dv.controller.model.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class User extends UserLogin {
    @NotBlank(message = "Password is mandatory")
    private String confirmPass;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;
}
