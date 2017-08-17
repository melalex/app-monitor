package com.appmonitor.webservice.assemblers;

import com.appmonitor.webservice.dto.InstallDto;
import com.appmonitor.webservice.resources.ApplicationResource;
import com.appmonitor.webservice.resources.InstallResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

@Component
public class InstallAssembler implements ResourceAssembler<InstallDto, InstallResource> {
    private ModelMapper modelMapper;
    private RelProvider relProvider;
    private EntityLinks entityLinks;

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setRelProvider(RelProvider relProvider) {
        this.relProvider = relProvider;
    }

    @Autowired
    public void setEntityLinks(EntityLinks entityLinks) {
        this.entityLinks = entityLinks;
    }

    @Override
    public InstallResource toResource(InstallDto entity) {
        InstallResource installResource = modelMapper.map(entity, InstallResource.class);
        Link applicationLink = entityLinks.linkToSingleResource(ApplicationResource.class, entity.getApplication().getId())
                .withRel(relProvider.getItemResourceRelFor(ApplicationResource.class));

        installResource.add(applicationLink);

        return installResource;
    }
}
