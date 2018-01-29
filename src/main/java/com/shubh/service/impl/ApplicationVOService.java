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
import com.shubh.jpa.entity.ApplicationVO;
import com.shubh.service.interfaces.IApplicationVO;
/**
 *  Service for ApplicationVOService to handle db transactions
 * @author Shubham Bhindwal
 *
 */
@Service
@Transactional
public class ApplicationVOService implements IApplicationVO {

	private static Logger logger = LoggerFactory
			.getLogger(ApplicationVOService.class);

	@Autowired
	private SessionFactory session;

	public Session getSession() {
		return session.getCurrentSession();
	}

	@Override
	public void create(ApplicationVO applicationVO)
			throws AppDemoMessageException {
		getSession().saveOrUpdate(applicationVO);
	}

	@Override
	public ApplicationVO get(Long applicationVOId)
			throws AppDemoMessageException {
		return getSession().get(ApplicationVO.class, applicationVOId);
	}

	@Override
	public void update(ApplicationVO applicationVO)
			throws AppDemoMessageException {
		getSession().update(applicationVO);
	}

	@Override
	public List<ApplicationVO> getAll() throws AppDemoMessageException {
		return getSession().createCriteria(ApplicationVO.class).list();
	}

	@Override
	public void delete(Long applicationVOId) throws AppDemoMessageException {
		logger.info("Inside deleteFromDB method of agency service");

		ApplicationVO applicationVO = get(applicationVOId);

		if (applicationVO == null) {
			logger.error("applicationVO with id: " + applicationVOId
					+ "not found, Invalid ID");
		}

		getSession().delete(applicationVO);

		logger.debug("applicationVO with id: " + applicationVOId
				+ " has been deleted");
		logger.info("Exiting deleteFromDB method of agency service");
	}

}
