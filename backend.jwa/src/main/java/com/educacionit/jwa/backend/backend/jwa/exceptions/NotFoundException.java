package com.educacionit.jwa.backend.backend.jwa.exceptions;

public class NotFoundException extends GenericException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ErrorEnum error;

	public NotFoundException(ErrorEnum error) {
		super(error.getDescription(), error.getCode());
	}	
	
}
