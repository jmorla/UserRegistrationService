package com.gallerin.common.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorDescriptor {

	private Date timestamp;
	private String path;
	private String message;
	private String exceptionName;
	private Integer statusCode;
	private List<FieldValidationError> errors = new ArrayList<FieldValidationError>();
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getExceptionName() {
		return exceptionName;
	}
	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public List<FieldValidationError> getErrors() {
		return errors;
	}
	public void setErrors(List<FieldValidationError> errors) {
		this.errors = errors;
	}
}
