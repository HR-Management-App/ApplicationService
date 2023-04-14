package com.beaconfire.applicationservice.service;

import com.beaconfire.applicationservice.dao.ApplicationDao;
import com.beaconfire.applicationservice.domain.entity.ApplicationWorkFlow;
import com.beaconfire.applicationservice.domain.entity.DigitalDocument;
import com.beaconfire.applicationservice.domain.misc.ApplicationStatus;
import com.beaconfire.applicationservice.domain.request.ApplicationUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class ApplicationService {
    private ApplicationDao appDao;

    @Autowired
    public void setAppDao(ApplicationDao appDao) {this.appDao = appDao;}

   @Transactional
    public ApplicationWorkFlow getApplicationByEmployeeID(int id) {
       Optional<ApplicationWorkFlow> optionalApp = appDao.getApplicationByEmployeeID(id);
       if (!optionalApp.isPresent()) {
           return ApplicationWorkFlow.builder().status(ApplicationStatus.NEVER_SUBMITTED).build();
       } else {
           return optionalApp.get();
       }
    }

    @Transactional
    public int createNewApplication(int employee_id) {
        return appDao.createNewApplication(employee_id);
    }

    @Transactional
    public ApplicationWorkFlow updateApplication(ApplicationUpdateRequest request) {
        return appDao.updateApplication(request);
    }

}