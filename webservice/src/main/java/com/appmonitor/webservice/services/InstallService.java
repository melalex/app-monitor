package com.appmonitor.webservice.services;

import com.appmonitor.webservice.dto.ApplicationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InstallService {

    void installApplication(String packageName, String ipAddress);

    Page<ApplicationDto> findByApplicationId(long id, Pageable pageable);
}
