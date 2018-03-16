package org.jmorla.common.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	private String classname;
	private String params;
	
	public ResourceNotFoundException(String classname, String params) {
		this.classname = classname;
		this.params = params;
	}
	
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	
	
}
