package com.appmonitor.webservice.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = -5622662762323736140L;

    @Id
    private String login;
    private String password;
}
