package com.gallerin.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gallerin.common.exception.DuplicateResourceException;
import com.gallerin.common.exception.ResourceNotFoundException;
import com.gallerin.common.pojo.ErrorDescriptor;
import com.gallerin.common.pojo.FieldValidationError;
import com.gallerin.common.pojo.MessageType;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorDescriptor> handleValidationError(MethodArgumentNotValidException exception, 
			HttpServletRequest request){
		
		ErrorDescriptor descriptor = new ErrorDescriptor();
		descriptor.setTimestamp(new Date());
		descriptor.setStatusCode(HttpStatus.BAD_REQUEST.value());
		descriptor.setExceptionName(exception.getClass().getName());
		descriptor.setPath(request.getRequestURI());
		descriptor.setMessage("Input field validation failed");
		
		BindingResult result = exception.getBindingResult();
		List<FieldError> errorList = result.getFieldErrors();
		
		List<FieldValidationError>  validationErrors = errorList.stream().map
				 (AppExceptionHandler::processFieldError).collect(Collectors.toList());
		
		descriptor.setErrors(validationErrors);
		
		return new ResponseEntity<ErrorDescriptor>(descriptor,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorDescriptor> handleResourceNotFoundException(ResourceNotFoundException exception,
			HttpServletRequest request){
		
		ErrorDescriptor descriptor = new ErrorDescriptor();
		descriptor.setTimestamp(new Date());
		descriptor.setStatusCode(HttpStatus.NOT_FOUND.value());
		descriptor.setExceptionName(exception.getClass().getName());
		descriptor.setPath(request.getRequestURI());
		descriptor.setMessage(constructMessage(exception.getClassname(), exception.getParams()));
		
		return new ResponseEntity<ErrorDescriptor>(descriptor, HttpStatus.NOT_FOUND);
	}
	
	
	public ResponseEntity<ErrorDescriptor> handleDuplicateResourceException(DuplicateResourceException exception,
			HttpServletRequest request){
		
		ErrorDescriptor descriptor = new ErrorDescriptor();
		descriptor.setTimestamp(new Date());
		descriptor.setStatusCode(HttpStatus.CONFLICT.value());
		descriptor.setExceptionName(exception.getClass().getName());
		descriptor.setPath(request.getRequestURI());
		descriptor.setMessage(exception.getMessage());
		
		return new ResponseEntity<ErrorDescriptor>(descriptor, HttpStatus.CONFLICT);
	}
	
	private String constructMessage(String entity, String searchParams) {
		return entity+" entity was not found for parameters "+searchParams;
	}
	
	private static FieldValidationError processFieldError(final FieldError fieldError) {
		FieldValidationError field = new FieldValidationError();
		
		if(fieldError != null) {
			field.setField(fieldError.getField());
			field.setType(MessageType.ERROR);
			field.setMessage(fieldError.getDefaultMessage());
		}
		
		return field;
	}
}
