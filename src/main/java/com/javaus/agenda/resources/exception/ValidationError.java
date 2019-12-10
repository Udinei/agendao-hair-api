package com.javaus.agenda.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
                      
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();
	
	

	public ValidationError(Long timeStamp, Integer status, String error, String message, String exception, String path) {
		super(timeStamp, status, error, message, exception, path);
		
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String messagem){
		errors.add(new FieldMessage(fieldName, messagem));
	}

	

}
