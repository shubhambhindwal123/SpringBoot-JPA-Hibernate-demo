package com.shubh.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shubh.dto.MessageDTO;
import com.shubh.exception.custom.AppDemoMessageException;
import com.shubh.jpa.entity.ApplicationGroup;
import com.shubh.service.interfaces.IApplicationGroupService;

/**
 * This is ApplicationGroupController and will handle all request 
 * 
 * @author Shubham Bhindwal
 *
 */

@RestController
@RequestMapping("/applicationGroup")
public class ApplicationGroupController {

    final static Logger logger = Logger.getLogger(ApplicationGroupController.class);

    /**
     * This method is used to add ApplicationGroup.
     * 
     * @param ApplicationGroup
     * @return ResponseDto<ApplicationGroup>
     */

    @Autowired
    private IApplicationGroupService applicationGroupService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<MessageDTO<ApplicationGroup>> addApplication(
            @Validated @RequestBody ApplicationGroup applicationGroup) throws AppDemoMessageException {
        logger.info("Inside addApplication method of ApplicationController");
        applicationGroupService.create(applicationGroup);
        return new ResponseEntity<MessageDTO<ApplicationGroup>>(new MessageDTO<ApplicationGroup>(
                " ApplicationGroup is saved successfully", applicationGroup), HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<MessageDTO<ApplicationGroup>> updateApplication(
            @Validated @RequestBody ApplicationGroup applicationGroup) throws AppDemoMessageException {
        logger.info("Inside updateApplication method of ApplicationController");
        applicationGroupService.update(applicationGroup);
        return new ResponseEntity<MessageDTO<ApplicationGroup>>(new MessageDTO<ApplicationGroup>(
                "ApplicationGroup is updated successfully", applicationGroup), HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteApplication(@Validated @PathVariable("id") Long id)
            throws AppDemoMessageException {
        logger.info("Inside deleteApplication method of ApplicationController");
        applicationGroupService.delete(id);
        /**
         * 
         */
        return new ResponseEntity<Object>(
                new MessageDTO<List<String>>("ApplicationGroup is deleted successfully", null), HttpStatus.OK);

    }

    @RequestMapping(value = "/{applicationId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getApplication(@Validated @PathVariable("applicationId") Long applicationId)
            throws AppDemoMessageException {
        logger.info("Inside getApplication method of ApplicationController");
        ApplicationGroup applicationGroup = applicationGroupService.get(applicationId);
        return new ResponseEntity<Object>(new MessageDTO<ApplicationGroup>("ApplicationGroup fetched successfully",
                applicationGroup), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> findAll() throws AppDemoMessageException {
        logger.info("Inside findAll method of ApplicationController");
        return new ResponseEntity<Object>(new MessageDTO<List<ApplicationGroup>>(
                "ApplicationGroup fetched successfully", applicationGroupService.getAll()), HttpStatus.OK);
    }
}
