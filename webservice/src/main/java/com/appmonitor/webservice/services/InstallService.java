package com.appmonitor.webservice.services;

import com.appmonitor.webservice.resources.InstallResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InstallService {

    void installApplication(String packageName, String ipAddress);

    Page<InstallResource> findByApplicationId(long id, Pageable pageable);
}
