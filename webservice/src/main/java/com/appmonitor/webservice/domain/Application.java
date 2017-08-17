package com.appmonitor.webservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(
        name = "application_information",
        indexes = @Index(name = "idx_package_name", columnList = "package_name", unique = true)
)
public class Application implements Serializable {
    private static final long serialVersionUID = -5035374505612058327L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "package_name", nullable = false, unique = true)
    private String packageName;

    @Column(length = 500)
    private String notes;

    @Column(name = "game_url", nullable = false)
    private String gameUrl;

    @Column(name = "hook_url", nullable = false)
    private String hookUrl;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "windows_server_url", nullable = false)
    private String windowsServerUrl;

    @Column(name = "windows_server_login", nullable = false)
    private String windowsServerLogin;

    @Column(name = "windows_server_password", nullable = false)
    private String windowsServerPassword;

    @Column(nullable = false)
    private boolean status;

    @Column(name = "installed_ips_status", nullable = false)
    private boolean installedIpsStatus;

    @OneToMany(targetEntity = Install.class)
    private Set<Install> installs;

    @Column(name = "installs_count")
    private int installsCount;
}
