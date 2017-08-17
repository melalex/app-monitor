package com.appmonitor.webservice.dto;

import com.appmonitor.webservice.constraints.FieldMatch;
import com.appmonitor.webservice.constraints.HardPassword;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@FieldMatch(
        first = "password",
        second = "passwordRetry"
)
public class UserForm implements Serializable {
    private static final long serialVersionUID = 4687230186870557566L;

    @NotNull
    @Size(min = 4, max = 255)
    private String login;

    @HardPassword
    private String password;

    private String passwordRetry;
}
