package com.appmonitor.webservice.repositories;

import com.appmonitor.webservice.domain.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicationRepository extends PagingAndSortingRepository<Application, Long> {

    Page<Application> findByPackageNameStartingWith(String packageName, Pageable pageable);
}
