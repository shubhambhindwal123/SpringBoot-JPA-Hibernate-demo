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
import com.shubh.jpa.entity.Application;
import com.shubh.service.interfaces.IApplicationService;

/**
 * This is PentaBaseAssetController and will handle all request 
 * 
 * 
 * @author Shubham Bhindwal
 *
 */

@RestController
@RequestMapping("/application")
public class ApplicationController {

    final static Logger logger = Logger.getLogger(ApplicationController.class);

    /**
     * This method is used to add Application.
     * 
     * @param Application
     * @return ResponseDto<Application>
     */

    @Autowired
    private IApplicationService applicationService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<MessageDTO<Application>> addApplication(@Validated @RequestBody Application application)
            throws AppDemoMessageException {

        logger.info("Inside addApplication method of ApplicationController");

        application = applicationService.create(application);

        logger.debug("Application is saved successfully ");

        return new ResponseEntity<MessageDTO<Application>>(new MessageDTO<Application>(
                " Application is saved successfully", application), HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<MessageDTO<Application>> updateApplication(@Validated @RequestBody Application application)
            throws AppDemoMessageException {

        logger.info("Inside updateApplication method of ApplicationController");

        applicationService.update(application);

        logger.debug("Application is updated successfully ");

        return new ResponseEntity<MessageDTO<Application>>(new MessageDTO<Application>(
                "Application is updated successfully", application), HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteApplication(@Validated @PathVariable("id") Long id)
            throws AppDemoMessageException {

        logger.info("Inside deleteApplication method of ApplicationController");

        applicationService.delete(id);

        logger.debug("Application deleted successfully ");

        return new ResponseEntity<Object>(new MessageDTO<List<String>>("Application is deleted successfully", null),
                HttpStatus.OK);

    }

    @RequestMapping(value = "/{applicationId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getApplication(@Validated @PathVariable("applicationId") Long applicationId)
            throws AppDemoMessageException {

        logger.info("Inside getApplication method of ApplicationController");

        Application application = applicationService.get(applicationId);

        logger.debug("Application fetched successfully ");

        return new ResponseEntity<Object>(new MessageDTO<Application>("Application fetched successfully", application),
                HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> findAll() throws AppDemoMessageException {

        logger.info("Inside findAll method of ApplicationController");

        return new ResponseEntity<Object>(new MessageDTO<List<Application>>("Application fetched successfully",
                applicationService.getAll()), HttpStatus.OK);

    }
}
