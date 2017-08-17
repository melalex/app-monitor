package com.appmonitor.webservice.repositories;

import com.appmonitor.webservice.domain.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ApplicationRepository extends PagingAndSortingRepository<Application, Long> {

    Application findByPackageName(String packageName);

    Page<Application> findByPackageNameStartingWith(String packageName, Pageable pageable);

    @Query("UPDATE Application as a SET a.installsCount = a.installsCount + 1 WHERE a.id = :id")
    void icrementInstallsCount(@Param("id") long id);
}
