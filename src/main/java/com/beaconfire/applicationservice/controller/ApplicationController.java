package com.beaconfire.applicationservice.controller;

import com.beaconfire.applicationservice.domain.entity.ApplicationWorkFlow;
import com.beaconfire.applicationservice.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/application-service")
public class ApplicationController {
    private ApplicationService service;

    @Autowired
    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    @GetMapping()
    public ApplicationWorkFlow getAppInfo() {
        return service.getApplicationById(1);
    }

}