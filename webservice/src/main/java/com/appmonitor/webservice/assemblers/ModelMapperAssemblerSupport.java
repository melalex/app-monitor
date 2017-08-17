package com.appmonitor.webservice.assemblers;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

abstract class ModelMapperAssemblerSupport<T, D extends ResourceSupport> extends ResourceAssemblerSupport<T, D> {
    private final ModelMapper modelMapper;
    private final Class<D> resourceType;

    ModelMapperAssemblerSupport(final Class<?> controllerClass, final Class<D> resourceType, final ModelMapper modelMapper) {
        super(controllerClass, resourceType);
        this.modelMapper = modelMapper;
        this.resourceType = resourceType;
    }

    @Override
    public D toResource(final T entity) {
        D resource = createResourceWithId(getId(entity), entity);
        addLinks(resource);

        return resource;
    }

    @Override
    protected D instantiateResource(final T entity) {
        return modelMapper.map(entity, resourceType);
    }

    protected void addLinks(D resource) {

    }

    protected abstract Object getId(T entity);
}

