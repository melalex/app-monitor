package com.appmonitor.webservice.resources;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class InstallResource extends ResourceSupport implements Serializable {
    private static final long serialVersionUID = -2770083997662454784L;

    private String ipAddress;
}
