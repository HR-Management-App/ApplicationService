package com.beaconfire.applicationservice.dao;

import com.beaconfire.applicationservice.domain.entity.ApplicationWorkFlow;
import org.springframework.stereotype.Repository;

@Repository
public class ApplicationDao extends AbstractHibernateDao<ApplicationWorkFlow> {

    public ApplicationDao() {
        setClazz(ApplicationWorkFlow.class);
    }

    public ApplicationWorkFlow getApplicationById(int id) {
        return this.findById(id);
    }
}