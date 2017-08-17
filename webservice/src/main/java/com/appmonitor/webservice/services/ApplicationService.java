package com.appmonitor.webservice.services;

import com.appmonitor.webservice.dto.ApplicationDto;
import com.appmonitor.webservice.dto.InstallDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ApplicationService {

    ApplicationDto create(ApplicationDto applicationDto);

    ApplicationDto find(long id);

    ApplicationDto findByPackageName(String packageName);

    Page<ApplicationDto> findAll(Pageable pageable);

    Page<ApplicationDto> findByPackageNameStartWith(String packageName, Pageable pageable);

    void update(long id, ApplicationDto applicationDto);

    void installApplication(String packageName, String ipAddress);

    Page<InstallDto> findByApplicationId(long id, Pageable pageable);
}