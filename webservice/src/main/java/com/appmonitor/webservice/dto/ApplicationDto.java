package com.appmonitor.webservice.dto;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ApplicationDto {

    @NotNull
    @Size(min = 6, max = 255)
    private String packageName;

    @URL
    @NotNull
    private String gameUrl;

    @Size(max = 500)
    private String notes;

    @URL
    private String hookUrl;

    @URL
    private String imageUrl;

    @URL
    @NotNull
    private String windowsServerUrl;

    @NotNull
    private String windowsServerLogin;

    @NotNull
    private String windowsServerPassword;

    private boolean status;
    private boolean installedIpsStatus;

    @NotNull
    private int installsCount;
}
