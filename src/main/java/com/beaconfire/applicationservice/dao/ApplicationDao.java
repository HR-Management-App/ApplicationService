package com.beaconfire.applicationservice.dao;

import com.beaconfire.applicationservice.domain.entity.ApplicationWorkFlow;
import com.beaconfire.applicationservice.domain.misc.ApplicationStatus;
import com.beaconfire.applicationservice.domain.request.ApplicationUpdateRequest;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.security.Timestamp;
import java.util.Date;
import java.util.Optional;

@Repository
public class ApplicationDao extends AbstractHibernateDao<ApplicationWorkFlow> {

    public ApplicationDao() {
        setClazz(ApplicationWorkFlow.class);
    }

    public ApplicationWorkFlow getApplicationById(int id) {
        return this.findById(id);
    }

    public Optional<ApplicationWorkFlow> getApplicationByEmployeeID(int employee_id) {
        return this.findApplicationByEmployeeID(employee_id);
    }

    public int createNewApplication(int employee_id) {
        Session session = getCurrentSession();
        ApplicationWorkFlow app = ApplicationWorkFlow.builder()
                .employee_id(employee_id)
                .status(ApplicationStatus.PENDING)
                .create_date(new Date())
                .last_modification_date(new Date())
                .build();
        int app_id = (Integer) session.save(app);
        return app_id;
    }

    public ApplicationWorkFlow updateApplication(ApplicationUpdateRequest request) {
        Session session = getCurrentSession();
        ApplicationWorkFlow app = this.findById(request.getId());
        app.setLast_modification_date(new Date());
        app.setStatus(request.getStatus());
        app.setComment(request.getComment());
        session.save(app);
        return app;
    }

}