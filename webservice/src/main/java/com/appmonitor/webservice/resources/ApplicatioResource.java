package com.appmonitor.webservice.resources;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class ApplicatioResource extends ResourceSupport implements Serializable {
    private static final long serialVersionUID = 8918421299883853589L;

    private String packageName;
    private String notes;
    private String gameUrl;
    private String hookUrl;
    private String imageUrl;
    private String windowsServerUrl;
    private String windowsServerLogin;
    private String windowsServerPassword;

    private boolean status;
    private boolean installedIpsStatus;

    private int installsCount;
}
