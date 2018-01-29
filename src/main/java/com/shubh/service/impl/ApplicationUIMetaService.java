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
import com.shubh.jpa.entity.ApplicationUIMetaData;
import com.shubh.service.interfaces.IApplicationMetaUIService;

/**
 * Service for ApplicationUIMetaService to handle db transactions
 * 
 * @author Shubham Bhindwal
 *
 */
@Service
@Transactional
public class ApplicationUIMetaService implements IApplicationMetaUIService {

    private static Logger logger = LoggerFactory.getLogger(ApplicationUIMetaService.class);

    @Autowired
    private SessionFactory session;

    /**
     * To get the session
     * 
     * @return Session
     */
    public Session getSession() {
        return session.getCurrentSession();
    }

    @Override
    public void create(ApplicationUIMetaData applicationUIMetaData) throws AppDemoMessageException {
        logger.info("Inside create method of ApplicationUIMetaData ");
        getSession().saveOrUpdate(applicationUIMetaData);
        logger.info("Exit create method of ApplicationUIMetaData ");
    }

    @Override
    public ApplicationUIMetaData get(Long applicationUIMetaDataId) throws AppDemoMessageException {
        logger.debug("Inside get method of ApplicationUIMetaData ");
        return getSession().get(ApplicationUIMetaData.class, applicationUIMetaDataId);
    }

    @Override
    public void update(ApplicationUIMetaData applicationUIMetaData) throws AppDemoMessageException {
        logger.info("Inside update method of ApplicationUIMetaData ");
        getSession().update(applicationUIMetaData);
        logger.info("Exit update method of ApplicationUIMetaData ");
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ApplicationUIMetaData> getAll() throws AppDemoMessageException {
        logger.debug("Inside getAll method of ApplicationUIMetaData ");
        return getSession().createCriteria(ApplicationUIMetaData.class).list();
    }

    @Override
    public void delete(Long applicationUIMetaDataId) throws AppDemoMessageException {
        logger.info("Inside deleteFromDB method of agency service");

        ApplicationUIMetaData applicationUIMetaData = get(applicationUIMetaDataId);

        if (applicationUIMetaData == null) {
            logger.error("applicationUIMetaData with id: " + applicationUIMetaDataId + "not found, Invalid ID");
        }

        getSession().delete(applicationUIMetaData);

        logger.debug("applicationUIMetaData with id: " + applicationUIMetaDataId + " has been deleted");
        logger.info("Exiting deleteFromDB method of agency service");
    }

}
