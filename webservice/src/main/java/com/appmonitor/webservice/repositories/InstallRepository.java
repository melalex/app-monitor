package com.appmonitor.webservice.repositories;

import com.appmonitor.webservice.domain.Install;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InstallRepository extends PagingAndSortingRepository<Install, Long> {

    Page<Install> findAllByApplication_PackageName(String packageName, Pageable pageable);
}
