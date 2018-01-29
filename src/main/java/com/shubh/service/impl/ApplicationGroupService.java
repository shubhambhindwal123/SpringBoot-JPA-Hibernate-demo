package com.shubh.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubh.exception.custom.AppDemoMessageException;
import com.shubh.jpa.entity.ApplicationGroup;
import com.shubh.service.interfaces.IApplicationGroupService;

/**
 * Service for ApplicationGroupService to handle db transactions
 * 
 * @author Shubham Bhindwal
 *
 */
@Service
@Transactional
public class ApplicationGroupService implements IApplicationGroupService {

    private static Logger logger = LoggerFactory.getLogger(ApplicationGroupService.class);

    @Autowired
    private SessionFactory session;

    public Session getSession() {
        return session.getCurrentSession();
    }

    @Override
    public void create(ApplicationGroup applicationGroup) throws AppDemoMessageException {
        logger.info("Inside create method of ApplicationGroup ");
        getSession().saveOrUpdate(applicationGroup);
        logger.info("Inside create method of ApplicationGroup ");
    }

    @Override
    public ApplicationGroup get(Long applicationGroupId) throws AppDemoMessageException {
        logger.debug("Inside create method of ApplicationGroup ");
        return getSession().get(ApplicationGroup.class, applicationGroupId);
    }

    @Override
    public void update(ApplicationGroup applicationGroup) throws AppDemoMessageException {
        logger.info("Inside update method of ApplicationGroup ");
        getSession().update(applicationGroup);
        logger.info("Inside update method of ApplicationGroup ");
    }

    @Override
    public List<ApplicationGroup> getAll() throws AppDemoMessageException {
        logger.debug("Inside getAll method of ApplicationGroup ");
        return getSession().createCriteria(ApplicationGroup.class).list();
    }

    @Override
    public void delete(Long applicationGroupId) throws AppDemoMessageException {
        logger.info("Inside deleteFromDB method of agency service");

        ApplicationGroup applicationGroup = get(applicationGroupId);

        if (applicationGroup == null) {
            logger.error("applicationGroup with id: " + applicationGroupId + "not found, Invalid ID");
        }

        getSession().delete(applicationGroup);
        SQLQuery query = getSession().createSQLQuery(
                "delete from application_applicationgroup where applicationGroups_id = " + applicationGroupId);
        query.executeUpdate();
        query = getSession().createSQLQuery("delete from applicationgroup where id = " + applicationGroupId);
        logger.debug("applicationGroup with id: " + applicationGroupId + " has been deleted");
        logger.info("Exiting deleteFromDB method of agency service");
    }

}
