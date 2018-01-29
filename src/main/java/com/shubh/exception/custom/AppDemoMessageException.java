package com.shubh.exception.custom;

import org.springframework.http.HttpStatus;
/**
 * 
 * AppDemoMessageException for entire application
 * @author Shubham Bhindwal
 *
 */
public class AppDemoMessageException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpStatus type;

	/**
	 * @return the type
	 */
	public HttpStatus getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(HttpStatus type) {
		this.type = type;
	}

	public AppDemoMessageException() {
	}

	public AppDemoMessageException(String message, HttpStatus type) {
		super(message);
		this.type = type;

	}

	public AppDemoMessageException(Throwable cause) {
		super(cause);
	}

	public AppDemoMessageException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppDemoMessageException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
