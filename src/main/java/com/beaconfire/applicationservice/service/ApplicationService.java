package com.beaconfire.applicationservice.service;

import com.beaconfire.applicationservice.dao.ApplicationDao;
import com.beaconfire.applicationservice.domain.entity.ApplicationWorkFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ApplicationService {
    private ApplicationDao appDao;

    @Autowired
    public void setAppDao(ApplicationDao appDao) {this.appDao = appDao;}

   @Transactional
    public ApplicationWorkFlow getApplicationById(int id) {
        return appDao.getApplicationById(id);
    }
}
