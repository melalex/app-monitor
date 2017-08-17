package com.appmonitor.webservice.dto;

import com.appmonitor.webservice.constraints.Image;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class ApplicationForm implements Serializable {
    private static final long serialVersionUID = -4613918053380822712L;

    @NotNull
    @Size(min = 6, max = 255)
    private String packageName;

    @URL
    @NotNull
    @Size(max = 255)
    private String gameUrl;

    @Size(max = 500)
    private String notes;

    @URL
    @NotNull
    @Size(max = 255)
    private String hookUrl;

    @Image
    @NotNull
    private MultipartFile image;

    @URL
    @NotNull
    @Size(max = 255)
    private String windowsServerUrl;

    @NotNull
    @Size(max = 255)
    private String windowsServerLogin;

    @NotNull
    @Size(max = 255)
    private String windowsServerPassword;

    private boolean status;
    private boolean installedIpsStatus;
}
