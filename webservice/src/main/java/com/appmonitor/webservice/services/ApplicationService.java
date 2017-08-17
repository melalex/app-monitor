package com.appmonitor.webservice.services;

import com.appmonitor.webservice.forms.ApplicationForm;
import com.appmonitor.webservice.resources.ApplicationResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ApplicationService {

    ApplicationResource create(ApplicationForm application);

    ApplicationResource find(long id);

    Page<ApplicationResource> findAll(Pageable pageable);

    Page<ApplicationResource> findByPackageName(String packageName, Pageable pageable);

    void update(ApplicationForm application);
}