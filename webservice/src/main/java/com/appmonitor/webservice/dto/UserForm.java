package com.appmonitor.webservice.dto;

import com.appmonitor.webservice.constraints.FieldMatch;
import com.appmonitor.webservice.constraints.HardPassword;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch(
        first = "password",
        second = "passwordRetry"
)
public class UserForm {

    @NotNull
    @Size(min = 4, max = 255)
    private String login;

    @HardPassword
    private String password;

    private String passwordRetry;
}
