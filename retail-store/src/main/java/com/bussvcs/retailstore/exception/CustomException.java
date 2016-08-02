package com.bussvcs.retailstore.exception;

/**
 * The Class CustomException.
 * @author Rutvij Newaskar
 */
public class CustomException extends Exception{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2901360628239871641L;
	
	/**
	 * Instantiates a new custom exception.
	 *
	 * @param message the message
	 */
	public CustomException(String message){
		super(message);
	}
	
	/**
	 * Instantiates a new custom exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public CustomException(String message, Throwable cause){
		super(message, cause);
	}

}
