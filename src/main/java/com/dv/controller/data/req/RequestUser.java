package com.dv.controller.data.req;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class RequestUser extends RequestUserLogin {
    @NotBlank(message = "Password is mandatory")
    private String confirmPass;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;
}
