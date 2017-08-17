package com.appmonitor.webservice.services.impl;

import com.appmonitor.webservice.domain.Application;
import com.appmonitor.webservice.domain.Install;
import com.appmonitor.webservice.dto.ApplicationDto;
import com.appmonitor.webservice.dto.InstallDto;
import com.appmonitor.webservice.forms.ApplicationForm;
import com.appmonitor.webservice.repositories.ApplicationRepository;
import com.appmonitor.webservice.repositories.InstallRepository;
import com.appmonitor.webservice.services.ApplicationService;
import com.appmonitor.webservice.services.FileStorageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {
    private ApplicationRepository applicationRepository;
    private InstallRepository installRepository;
    private ModelMapper modelMapper;
    private FileStorageService fileStorageService;

    @Autowired
    public void setApplicationRepository(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Autowired
    public void setInstallRepository(InstallRepository installRepository) {
        this.installRepository = installRepository;
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
    public ApplicationDto create(ApplicationForm applicationForm) {
        Application application = modelMapper.map(applicationForm, Application.class);
        populateImageUrl(applicationForm, application);

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
    public ApplicationDto findByPackageName(String packageName) {
        Application application = applicationRepository.findByPackageName(packageName);

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
    public Page<ApplicationDto> findByPackageNameStartWith(String packageName, Pageable pageable) {
        Page<Application> applicationPage = applicationRepository.findByPackageNameStartingWith(packageName, pageable);

        return applicationPage.map(e -> modelMapper.map(e, ApplicationDto.class));
    }

    @Override
    public void update(long id, ApplicationForm applicationForm) {
        Application application = modelMapper.map(applicationForm, Application.class);
        application.setId(id);

        populateWithOldImageUrl(id, application);
        populateImageUrl(applicationForm, application);

        applicationRepository.save(application);
    }

    @Override
    public void installApplication(String packageName, String ipAddress) {
        Application application = applicationRepository.findByPackageName(packageName);

        if (application.isInstalledIpsStatus()) {
            installApplication(application, ipAddress);
        }

        applicationRepository.icrementInstallsCount(application.getId());
    }

    @Override
    public Page<InstallDto> findByApplicationId(long id, Pageable pageable) {
        Page<Install> applicationPage = installRepository.findAllByApplication_Id(id, pageable);

        return applicationPage.map(e -> modelMapper.map(e, InstallDto.class));
    }

    private void installApplication(Application application, String ipAddress) {
        if (isNotContainsIp(application, ipAddress)) {
            Install install = new Install();

            install.setIpAddress(ipAddress);
            install.setApplication(application);

            installRepository.save(install);
        }
    }

    private boolean isNotContainsIp(Application application, String ipAddress) {
        return installRepository.countByApplicationAndIpAddress(application, ipAddress) <= 0;
    }

    private void populateImageUrl(ApplicationForm applicationForm, Application application) {
        MultipartFile image = applicationForm.getImage();
        String imageUrl = null;

        if (image != null) {
            imageUrl = fileStorageService.storeFile(applicationForm.getImage());
        }

        application.setImageUrl(imageUrl);
    }

    private void populateWithOldImageUrl(long id, Application application) {
        Application oldApplication = applicationRepository.findOne(id);
        String imageUrl = null;

        if (oldApplication != null) {
            imageUrl = oldApplication.getImageUrl();
        }

        application.setImageUrl(imageUrl);
    }
}
