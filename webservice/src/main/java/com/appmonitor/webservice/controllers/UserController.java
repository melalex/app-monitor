package com.appmonitor.webservice.controllers;

import com.appmonitor.webservice.resources.UserResource;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(UserResource.class)
public class UserController {
}
