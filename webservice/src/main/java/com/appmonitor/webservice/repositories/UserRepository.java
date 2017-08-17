package com.appmonitor.webservice.repositories;

import com.appmonitor.webservice.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
