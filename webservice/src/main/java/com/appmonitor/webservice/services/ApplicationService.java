package com.appmonitor.webservice.services;

import com.appmonitor.webservice.dto.ApplicationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ApplicationService {

    ApplicationDto create(ApplicationDto applicationDto);

    ApplicationDto find(long id);

    Page<ApplicationDto> findAll(Pageable pageable);

    Page<ApplicationDto> findByPackageName(String packageName, Pageable pageable);

    void update(long id, ApplicationDto applicationDto);
}