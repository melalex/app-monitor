package com.appmonitor.webservice.domain;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class User {
    private String login;
    private String password;
}
