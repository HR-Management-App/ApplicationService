package com.beaconfire.applicationservice.controller;

import com.beaconfire.applicationservice.domain.entity.ApplicationWorkFlow;
import com.beaconfire.applicationservice.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application-service")
public class ApplicationController {
    private ApplicationService service;

    @Autowired
    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    @GetMapping("/status")
    public ResponseEntity<ApplicationWorkFlow> getAppInfo(@RequestParam(value = "employee_id") int employee_id) {
        return new ResponseEntity<>(service.getApplicationByEmployeeID(employee_id), HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<Integer> createNewApplication(@RequestParam(value = "employee_id") int employee_id) {
        int app_id =  service.createNewApplication(employee_id);
        return new ResponseEntity<>(app_id, HttpStatus.OK);
    }

}