package org.jmorla.controller.errorhandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.jmorla.common.pojo.FieldValidationError;
import org.jmorla.common.pojo.MessageType;
import org.jmorla.common.exception.ResourceNotFoundException;
import org.jmorla.common.pojo.ErrorDescriptor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	public ResponseEntity<ErrorDescriptor> handleResourceNotFoundException(ResourceNotFoundException exception,
			HttpServletRequest request){
		
		ErrorDescriptor descriptor = new ErrorDescriptor();
		descriptor.setTimestamp(new Date());
		descriptor.setStatusCode(HttpStatus.NOT_FOUND.value());
		descriptor.setExceptionName(exception.getClass().getName());
		descriptor.setPath(request.getRequestURI());
		descriptor.setMessage(constructMessage(exception.getClassname(), exception.getParams()));
		
		return null;
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
