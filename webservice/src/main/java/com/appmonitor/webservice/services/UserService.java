package com.appmonitor.webservice.services;

import com.appmonitor.webservice.forms.UserForm;
import com.appmonitor.webservice.resources.UserResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResource create(UserForm user);

    UserResource find(long id);

    Page<UserResource> findAll(Pageable pageable);

    Page<UserResource> findByPackageName(String packageName, Pageable pageable);

    void update(UserForm user);
}
