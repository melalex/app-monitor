package com.appmonitor.webservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class InstalledIp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ip_address", length = 40, unique = true)
    private String ipAddress;

    @JoinColumn(name = "package_name")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Application application;
}
