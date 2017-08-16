package com.appmonitor.webservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "application_information")
public class Application {

    @Id
    @Column(name = "package_name")
    private String packageName;

    @Column(length = 500)
    private String notes;

    @Column(name = "game_url")
    private String gameUrl;

    @Column(name = "hook_url")
    private String hookUrl;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "image_url")
    private String windowsServerUrl;

    @Column(name = "image_url")
    private String windowsServerLogin;

    @Column(name = "image_url")
    private String windowsServerPassword;

    private boolean status;

    @Column(name = "installed_ips_status")
    private boolean installedIpsStatus;

    @OneToMany(targetEntity = Install.class)
    private Set<Install> installs;

    @Column(name = "installs_count")
    private int installsCount;
}
