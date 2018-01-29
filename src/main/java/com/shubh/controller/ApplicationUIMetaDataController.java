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
import com.shubh.jpa.entity.ApplicationUIMetaData;
import com.shubh.service.interfaces.IApplicationGroupService;
import com.shubh.service.interfaces.IApplicationMetaUIService;

/**
 * This is ApplicationUIMetaDataController and will handle all request
 * 
 * 
 * @author Shubham Bhindwal
 *
 */

@RestController
@RequestMapping("/applicationUI")
public class ApplicationUIMetaDataController {

    final static Logger logger = Logger.getLogger(ApplicationUIMetaDataController.class);

    /**
     * This method is used to add ApplicationUIMetaData.
     * 
     * @param ApplicationUIMetaData
     * @return ResponseDto<ApplicationUIMetaData>
     */

    @Autowired
    private IApplicationMetaUIService applicationUIService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<MessageDTO<ApplicationUIMetaData>> addApplication(
            @Validated @RequestBody ApplicationUIMetaData applicationUIMetaData) throws AppDemoMessageException {
        logger.info("Inside addApplication method of ApplicationController");
  
        applicationUIService.create(applicationUIMetaData);
        
        logger.debug("exit addApplication method of ApplicationController");
        
        return new ResponseEntity<MessageDTO<ApplicationUIMetaData>>(new MessageDTO<ApplicationUIMetaData>(
                " ApplicationUIMetaData is saved successfully", applicationUIMetaData), HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<MessageDTO<ApplicationUIMetaData>> updateApplication(
            @Validated @RequestBody ApplicationUIMetaData applicationUIMetaData) throws AppDemoMessageException {
       
        logger.info("Inside updateApplication method of ApplicationController");
        
        applicationUIService.update(applicationUIMetaData);
        
        logger.debug("exit updateApplication method of ApplicationController");
        
        return new ResponseEntity<MessageDTO<ApplicationUIMetaData>>(new MessageDTO<ApplicationUIMetaData>(
                "ApplicationUIMetaData is updated successfully", applicationUIMetaData), HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteApplication(@Validated @PathVariable("id") Long id)
            throws AppDemoMessageException {
      
        logger.info("Inside deleteApplication method of ApplicationController");
        
        applicationUIService.delete(id);
        
        logger.debug("exit deleteApplication method of ApplicationController");
        
        return new ResponseEntity<Object>(new MessageDTO<List<String>>("ApplicationUIMetaData is deleted successfully",
                null), HttpStatus.OK);

    }

    @RequestMapping(value = "/{applicationId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getApplication(@Validated @PathVariable("applicationId") Long applicationId)
            throws AppDemoMessageException {
        logger.info("Inside getApplication method of ApplicationController");
        
        ApplicationUIMetaData applicationUIMetaData = applicationUIService.get(applicationId);
        
        logger.debug("exit getApplication method of ApplicationController");
        
        return new ResponseEntity<Object>(new MessageDTO<ApplicationUIMetaData>(
                "ApplicationUIMetaData fetched successfully", applicationUIMetaData), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> findAll() throws AppDemoMessageException {
        
        logger.info("Inside findAll method of ApplicationController");
        
        return new ResponseEntity<Object>(new MessageDTO<List<ApplicationUIMetaData>>(
                "ApplicationUIMetaData fetched successfully", applicationUIService.getAll()), HttpStatus.OK);

    }
}
