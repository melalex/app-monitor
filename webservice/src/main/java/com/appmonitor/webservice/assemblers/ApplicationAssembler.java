package com.appmonitor.webservice.assemblers;

import com.appmonitor.webservice.controllers.ApplicationController;
import com.appmonitor.webservice.dto.ApplicationDto;
import com.appmonitor.webservice.resources.ApplicationResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationAssembler extends ModelMapperAssemblerSupport<ApplicationDto, ApplicationResource> {

    @Autowired
    public ApplicationAssembler(ModelMapper modelMapper) {
        super(ApplicationController.class, ApplicationResource.class, modelMapper);
    }

    @Override
    protected void addLinks(ApplicationResource resource) {
        super.addLinks(resource);
    }

    @Override
    protected Object getId(ApplicationDto entity) {
        return entity.getId();
    }
}
