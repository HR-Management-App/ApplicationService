package com.beaconfire.applicationservice.dao;

import com.beaconfire.applicationservice.domain.entity.ApplicationWorkFlow;
import com.beaconfire.applicationservice.domain.entity.DigitalDocument;
import com.beaconfire.applicationservice.domain.misc.ApplicationStatus;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class DigitalDao extends AbstractHibernateDao<DigitalDocument> {

    public DigitalDao() {
        setClazz(DigitalDocument.class);
    }

    public DigitalDocument getDocumentById(int id) {
        return this.findById(id);
    }

    public DigitalDocument getDocumentByType(String type) {
        Session session = getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<DigitalDocument> criteria = builder.createQuery(DigitalDocument.class);
        Root<DigitalDocument> root = criteria.from(DigitalDocument.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("type"), type));
        Query query = session.createQuery(criteria);
        List<DigitalDocument> docs = query.getResultList();

        return docs.get(0);

    }


}