package com.appmonitor.webservice.assemblers;

import com.appmonitor.webservice.controllers.UserController;
import com.appmonitor.webservice.dto.UserDto;
import com.appmonitor.webservice.resources.UserResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler extends ModelMapperAssemblerSupport<UserDto, UserResource>  {

    @Autowired
    public UserAssembler(ModelMapper modelMapper) {
        super(UserController.class, UserResource.class, modelMapper);
    }

    @Override
    protected Object getId(UserDto entity) {
        return entity.getId();
    }
}
