package com.appmonitor.webservice.dto;

import javax.validation.constraints.NotNull;

public class UserDto {

    @NotNull
    private String login;

    @NotNull
    private String password;
}
