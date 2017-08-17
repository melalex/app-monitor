package com.appmonitor.webservice.services.impl;

import com.appmonitor.webservice.domain.Application;
import com.appmonitor.webservice.dto.ApplicationDto;
import com.appmonitor.webservice.repositories.ApplicationRepository;
import com.appmonitor.webservice.services.ApplicationService;
import com.appmonitor.webservice.services.FileStorageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {
    private ApplicationRepository applicationRepository;
    private ModelMapper modelMapper;
    private FileStorageService fileStorageService;

    @Autowired
    public void setApplicationRepository(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setFileStorageService(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @Override
    public ApplicationDto create(ApplicationDto applicationDto) {
        Application application = modelMapper.map(applicationDto, Application.class);
        populateImageUrl(applicationDto, application);

        application = applicationRepository.save(application);

        return modelMapper.map(application, ApplicationDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public ApplicationDto find(long id) {
        Application application = applicationRepository.findOne(id);

        return modelMapper.map(application, ApplicationDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ApplicationDto> findAll(Pageable pageable) {
        Page<Application> applicationPage = applicationRepository.findAll(pageable);

        return applicationPage.map(e -> modelMapper.map(e, ApplicationDto.class));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ApplicationDto> findByPackageName(String packageName, Pageable pageable) {
        Page<Application> applicationPage = applicationRepository.findByPackageNameStartingWith(packageName, pageable);

        return applicationPage.map(e -> modelMapper.map(e, ApplicationDto.class));
    }

    @Override
    public void update(long id, ApplicationDto applicationDto) {
        Application application = modelMapper.map(applicationDto, Application.class);
        application.setId(id);

        populateImageUrl(applicationDto, application);

        applicationRepository.save(application);
    }

    private void populateImageUrl(ApplicationDto applicationDto, Application application) {
        String imageUrl = fileStorageService.storeFile(applicationDto.getImage());

        application.setImageUrl(imageUrl);
    }
}
