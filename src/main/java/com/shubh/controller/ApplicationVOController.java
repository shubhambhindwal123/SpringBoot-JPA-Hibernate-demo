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
import com.shubh.jpa.entity.ApplicationVO;
import com.shubh.service.interfaces.IApplicationService;
import com.shubh.service.interfaces.IApplicationVO;

/**
 * This is ApplicationVOController and will handle all request
 * 
 * 
 * @author Shubham Bhindwal
 *
 */

@RestController
@RequestMapping("/applicationVO")
public class ApplicationVOController {

	final static Logger logger = Logger
			.getLogger(ApplicationVOController.class);

	/**
	 * This method is used to add ApplicationVO.
	 * 
	 * @param ApplicationVO
	 * @return ResponseDto<ApplicationVO>
	 */

	@Autowired
	private IApplicationVO applicationVOService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<MessageDTO<ApplicationVO>> addApplication(
			@Validated @RequestBody ApplicationVO ApplicationVO)
			throws AppDemoMessageException {
		logger.info("Inside addApplication method of ApplicationController");
		applicationVOService.create(ApplicationVO);
		return new ResponseEntity<MessageDTO<ApplicationVO>>(
				new MessageDTO<ApplicationVO>(
						" ApplicationVO is saved successfully", ApplicationVO),
				HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<MessageDTO<ApplicationVO>> updateApplication(
			@Validated @RequestBody ApplicationVO ApplicationVO)
			throws AppDemoMessageException {
		logger.info("Inside updateApplication method of ApplicationController");
		applicationVOService.update(ApplicationVO);
		return new ResponseEntity<MessageDTO<ApplicationVO>>(
				new MessageDTO<ApplicationVO>(
						"ApplicationVO is updated successfully", ApplicationVO),
				HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteApplication(
			@Validated @PathVariable("id") Long id)
			throws AppDemoMessageException {
		logger.info("Inside deleteApplication method of ApplicationController");
		applicationVOService.delete(id);
		return new ResponseEntity<Object>(new MessageDTO<List<String>>(
				"ApplicationVO is deleted successfully", null), HttpStatus.OK);

	}

	@RequestMapping(value = "/{applicationId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getApplication(
			@Validated @PathVariable("applicationId") Long applicationId)
			throws AppDemoMessageException {
		logger.info("Inside getApplication method of ApplicationController");
		ApplicationVO ApplicationVO = applicationVOService.get(applicationId);
		return new ResponseEntity<Object>(new MessageDTO<ApplicationVO>(
				"ApplicationVO fetched successfully", ApplicationVO),
				HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> findAll() throws AppDemoMessageException {
		logger.info("Inside findAll method of ApplicationController");
		return new ResponseEntity<Object>(new MessageDTO<List<ApplicationVO>>(
				"ApplicationVO fetched successfully",
				applicationVOService.getAll()), HttpStatus.OK);

	}
}
