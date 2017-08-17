package com.appmonitor.webservice.services;

import com.appmonitor.webservice.dto.ApplicationDto;
import com.appmonitor.webservice.dto.InstallDto;
import com.appmonitor.webservice.forms.ApplicationForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ApplicationService {

    ApplicationDto create(ApplicationForm applicationForm);

    ApplicationDto find(long id);

    ApplicationDto findByPackageName(String packageName);

    Page<ApplicationDto> findAll(Pageable pageable);

    Page<ApplicationDto> findByPackageNameStartWith(String packageName, Pageable pageable);

    void update(long id, ApplicationForm applicationForm);

    void installApplication(String packageName, String ipAddress);

    Page<InstallDto> findByApplicationId(long id, Pageable pageable);
}