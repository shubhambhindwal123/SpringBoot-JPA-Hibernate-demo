package com.shubh.service.interfaces;

import java.util.List;

import com.shubh.exception.custom.AppDemoMessageException;
import com.shubh.jpa.entity.ApplicationGroup;

/**
 * 
 * @author Shubham Bhindwal
 *
 */
public interface IApplicationGroupService {

    /**
     * This method is to create applicationGroup
     * 
     * @param applicationGroup
     * @return
     * @throws AppDemoMessageException
     */
    public void create(ApplicationGroup applicationGroup) throws AppDemoMessageException;

    /**
     * This method is to get applicationGroup by id
     * 
     * @param applicationGroupId
     * @return
     * @throws AppDemoMessageException
     */
    public ApplicationGroup get(Long applicationGroupId) throws AppDemoMessageException;

    /**
     * This method is to update applicationGroup
     * 
     * @param applicationGroup
     * @return
     * @throws AppDemoMessageException
     */
    public void update(ApplicationGroup applicationGroup) throws AppDemoMessageException;

    /**
     * This method is to delete applicationGroup by id
     * 
     * @param applicationGroupId
     * @throws AppDemoMessageException
     */
    public void delete(Long applicationGroupId) throws AppDemoMessageException;

    /**
     * This method is to get all applicationGroup
     * 
     * @return
     * @throws AppDemoMessageException
     */
    public List<ApplicationGroup> getAll() throws AppDemoMessageException;

}
