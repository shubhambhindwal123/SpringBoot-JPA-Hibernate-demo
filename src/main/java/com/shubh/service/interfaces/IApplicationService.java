package com.shubh.service.interfaces;

import java.util.List;

import com.shubh.exception.custom.AppDemoMessageException;
import com.shubh.jpa.entity.Application;
/**
 * 
 * @author Shubham Bhindwal
 *
 */
public interface IApplicationService {

	/**
	 * This method is to create application
	 * 
	 * @param application
	 * @return
	 * @throws AppDemoMessageException
	 */
	public Application create(Application application)
			throws AppDemoMessageException;

	/**
	 * This method is to get application by id
	 * 
	 * @param applicationId
	 * @return
	 * @throws AppDemoMessageException
	 */
	public Application get(Long applicationId) throws AppDemoMessageException;

	/**
	 * This method is to update application
	 * 
	 * @param application
	 * @return
	 * @throws AppDemoMessageException
	 */
	public void update(Application application)
			throws AppDemoMessageException;

	/**
	 * This method is to delete application by id
	 * 
	 * @param applicationId
	 * @throws AppDemoMessageException
	 */
	public void delete(Long applicationId) throws AppDemoMessageException;

	/**
	 * This method is to get all application
	 * 
	 * @return
	 * @throws AppDemoMessageException
	 */
	public List<Application> getAll() throws AppDemoMessageException;

}
