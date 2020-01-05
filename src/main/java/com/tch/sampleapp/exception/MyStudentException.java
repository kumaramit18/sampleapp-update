package com.tch.sampleapp.exception;

import org.springframework.http.HttpStatus;

public class MyStudentException {

	private HttpStatus status;
	private String error;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
		
}
