package com.appmonitor.webservice.repositories;

import com.appmonitor.webservice.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
