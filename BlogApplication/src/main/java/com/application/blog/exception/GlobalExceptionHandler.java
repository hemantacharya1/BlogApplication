package com.application.blog.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<MyErrorDetails> ResourceNotFoundExceptionHandler(ResourceNotFoundException exception){
		
		MyErrorDetails error=new MyErrorDetails();
		error.setDate(LocalDateTime.now());
		error.setMessage(exception.getMessage());
		
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.NOT_FOUND);
	}
}
