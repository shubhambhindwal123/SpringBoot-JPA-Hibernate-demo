package com.shubh.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubh.exception.custom.AppDemoMessageException;
import com.shubh.jpa.entity.Application;
import com.shubh.service.interfaces.IApplicationService;

/**
 * Service for ApplicationService to handle db transactions
 * 
 * @author Shubham Bhindwal
 *
 */
@Service
@Transactional
public class ApplicationService implements IApplicationService {

    private static Logger logger = LoggerFactory.getLogger(ApplicationService.class);

    @Autowired
    private SessionFactory session;

    public Session getSession() {
        return session.getCurrentSession();
    }

    @Override
    public Application create(Application application) throws AppDemoMessageException {
        getSession().saveOrUpdate(application);
        return get(application.getId());
    }

    @Override
    public Application get(Long applicationId) throws AppDemoMessageException {
        return getSession().get(Application.class, applicationId);
    }

    @Override
    public void update(Application application) throws AppDemoMessageException {
        getSession().update(application);
    }

    @Override
    public List<Application> getAll() throws AppDemoMessageException {
        return getSession().createCriteria(Application.class).list();
    }

    @Override
    public void delete(Long applicationId) throws AppDemoMessageException {
        logger.info("Inside deleteFromDB method of agency service");

        Application application = get(applicationId);

        if (application == null) {
            logger.error("application with id: " + applicationId + "not found, Invalid ID");
        }

        getSession().delete(application);

        logger.debug("application with id: " + applicationId + " has been deleted");
        logger.info("Exiting deleteFromDB method of agency service");
    }

}
