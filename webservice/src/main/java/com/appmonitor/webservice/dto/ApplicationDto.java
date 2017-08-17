package com.appmonitor.webservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApplicationDto implements Serializable {
    private static final long serialVersionUID = -8502462263686068654L;

    private long id;

    private String packageName;
    private String gameUrl;
    private String notes;
    private String hookUrl;
    private String imageUrl;
    private String windowsServerUrl;
    private String windowsServerLogin;
    private String windowsServerPassword;

    private boolean status;
    private boolean installedIpsStatus;

    private int installsCount;
}
