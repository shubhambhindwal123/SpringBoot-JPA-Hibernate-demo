package com.shubh.service.interfaces;

import java.util.List;

import com.shubh.exception.custom.AppDemoMessageException;
import com.shubh.jpa.entity.ApplicationUIMetaData;
/**
 * 
 * @author Shubham Bhindwal
 *
 */
public interface IApplicationMetaUIService {

	/**
	 * This method is to create applicationUIMetaData
	 * 
	 * @param applicationUIMetaData
	 * @return
	 * @throws AppDemoMessageException
	 */
	public void create(ApplicationUIMetaData applicationUIMetaData)
			throws AppDemoMessageException;

	/**
	 * This method is to get applicationUIMetaData by id
	 * 
	 * @param applicationUIMetaDataId
	 * @return
	 * @throws AppDemoMessageException
	 */
	public ApplicationUIMetaData get(Long applicationUIMetaDataId) throws AppDemoMessageException;

	/**
	 * This method is to update applicationUIMetaData
	 * 
	 * @param applicationUIMetaData
	 * @return
	 * @throws AppDemoMessageException
	 */
	public void update(ApplicationUIMetaData applicationUIMetaData)
			throws AppDemoMessageException;

	/**
	 * This method is to delete applicationUIMetaData by id
	 * 
	 * @param applicationUIMetaDataId
	 * @throws AppDemoMessageException
	 */
	public void delete(Long applicationUIMetaDataId) throws AppDemoMessageException;

	/**
	 * This method is to get all applicationUIMetaData
	 * 
	 * @return
	 * @throws AppDemoMessageException
	 */
	public List<ApplicationUIMetaData> getAll() throws AppDemoMessageException;

}
