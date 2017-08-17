package com.appmonitor.webservice.controllers;

import com.appmonitor.webservice.resources.ApplicationResource;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(ApplicationResource.class)
public class ApplicationController {
}
