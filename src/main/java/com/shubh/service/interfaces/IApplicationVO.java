package com.shubh.service.interfaces;

import java.util.List;

import com.shubh.exception.custom.AppDemoMessageException;
import com.shubh.jpa.entity.ApplicationVO;
/**
 * 
 * @author Shubham Bhindwal
 *
 */
public interface IApplicationVO {

	/**
	 * This method is to create applicationVO
	 * 
	 * @param applicationVO
	 * @return
	 * @throws AppDemoMessageException
	 */
	public void create(ApplicationVO applicationVO)
			throws AppDemoMessageException;

	/**
	 * This method is to get applicationVO by id
	 * 
	 * @param applicationVOId
	 * @return
	 * @throws AppDemoMessageException
	 */
	public ApplicationVO get(Long applicationVOId) throws AppDemoMessageException;

	/**
	 * This method is to update applicationVO
	 * 
	 * @param applicationVO
	 * @return
	 * @throws AppDemoMessageException
	 */
	public void update(ApplicationVO applicationVO)
			throws AppDemoMessageException;

	/**
	 * This method is to delete applicationVO by id
	 * 
	 * @param applicationVOId
	 * @throws AppDemoMessageException
	 */
	public void delete(Long applicationVOId) throws AppDemoMessageException;

	/**
	 * This method is to get all applicationVO
	 * 
	 * @return
	 * @throws AppDemoMessageException
	 */
	public List<ApplicationVO> getAll() throws AppDemoMessageException;

}
