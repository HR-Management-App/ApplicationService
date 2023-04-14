package com.beaconfire.applicationservice.controller;

import com.beaconfire.applicationservice.domain.entity.ApplicationWorkFlow;
import com.beaconfire.applicationservice.domain.entity.DigitalDocument;
import com.beaconfire.applicationservice.domain.request.ApplicationUpdateRequest;
import com.beaconfire.applicationservice.service.ApplicationService;
import com.beaconfire.applicationservice.service.DigitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application-service")
public class ApplicationController {
    private ApplicationService service;
    private DigitalService digitalService;

    @Autowired
    public ApplicationController(ApplicationService service, DigitalService digitalService)
    {
        this.service = service;
        this.digitalService = digitalService;
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

    @PutMapping("/update")
    public ResponseEntity<ApplicationWorkFlow> updateApplication(@RequestBody ApplicationUpdateRequest request) {
       return new ResponseEntity<>(service.updateApplication(request), HttpStatus.OK);
    }

    @GetMapping("/digital")
    public ResponseEntity<String> getDigitalDocument(@RequestParam String type) {
        DigitalDocument doc = digitalService.getDocumentByType(type);
        String response = "{\"path\" : \""+ doc.getPath() + "\"}";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}