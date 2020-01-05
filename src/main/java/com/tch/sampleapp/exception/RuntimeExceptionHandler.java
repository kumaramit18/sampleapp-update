package com.tch.sampleapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RuntimeExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(StudentException.class)
	public ResponseEntity<MyStudentException> customExceptionHandler(WebRequest webRequest){
		MyStudentException studentExcepton = new MyStudentException();
		studentExcepton.setStatus(HttpStatus.ACCEPTED);
		studentExcepton.setError("Object Not found");
		
		return new ResponseEntity<MyStudentException>(studentExcepton,studentExcepton.getStatus());
	}
}
