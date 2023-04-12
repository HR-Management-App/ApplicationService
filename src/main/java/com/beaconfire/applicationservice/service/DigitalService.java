package com.beaconfire.applicationservice.service;

import com.beaconfire.applicationservice.dao.ApplicationDao;
import com.beaconfire.applicationservice.dao.DigitalDao;
import com.beaconfire.applicationservice.domain.entity.DigitalDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DigitalService {
    private DigitalDao dao;
    @Autowired
    public void setAppDao(DigitalDao dao) {this.dao = dao;}

    @Transactional
    public DigitalDocument getDocumentByType(String type) {
        return dao.getDocumentByType(type);
    }

}