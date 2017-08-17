package com.appmonitor.webservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private static final long serialVersionUID = 4913515672177987808L;

    private long id;
    private String login;
    private String password;
}

