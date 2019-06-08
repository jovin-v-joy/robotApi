package com.jovin.robot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Status {
	private boolean success;
	@JsonInclude(Include.NON_NULL)
	private String error;
	
	public Status(boolean success, String error) {
		super();
		this.success = success;		
		this.error = error;
	}
	public Status(boolean success) {
		super();
		this.success = success;		
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
}
