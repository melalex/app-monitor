package com.appmonitor.webservice.services;

import com.appmonitor.webservice.dto.UserDto;
import com.appmonitor.webservice.forms.UserForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto create(UserForm user);

    UserDto find(long id);

    Page<UserDto> findAll(Pageable pageable);

    void update(long id, UserForm user);
}
