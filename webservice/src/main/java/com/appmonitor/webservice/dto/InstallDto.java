package com.appmonitor.webservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class InstallDto implements Serializable {
    private static final long serialVersionUID = -2550851778449567370L;

    private String ipAddress;
    private ApplicationDto application;
}

