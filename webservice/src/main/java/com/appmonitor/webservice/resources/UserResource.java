package com.appmonitor.webservice.resources;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserResource extends ResourceSupport implements Serializable {
    private static final long serialVersionUID = 8900534006939767889L;

    private long id;
    private String login;
    private String password;
}
