package com.appmonitor.webservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Install implements Serializable {
    private static final long serialVersionUID = -4815129180851966083L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ip_address", length = 40)
    private String ipAddress;

    @JoinColumn(name = "package_name")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Application application;
}
