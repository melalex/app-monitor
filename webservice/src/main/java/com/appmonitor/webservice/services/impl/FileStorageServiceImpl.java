package com.appmonitor.webservice.services.impl;

import com.appmonitor.webservice.services.FileStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Override
    public String storeFile(MultipartFile file) {
        return null;
    }
}
