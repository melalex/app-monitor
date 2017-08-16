package com.appmonitor.webservice.services;

import com.appmonitor.webservice.domain.Application;

public interface ApplicationService {

    void procciedApplicationInstall(String packageName, String ipAddress);

    Application createApplication();

    void updateApplication();
}
