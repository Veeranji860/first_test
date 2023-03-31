package com.user.registration.exception;

import java.net.ConnectException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(UserNotFound.class)
	  public ResponseEntity<ErrorCode> resourceNotFoundException(UserNotFound ex, WebRequest request) {
		ErrorCode message = new ErrorCode();
		message.setCode("1005");
		message.setMessage(ex.getMessage());
	    return new ResponseEntity<ErrorCode>(message,HttpStatus.NOT_FOUND);
	  }
	@ExceptionHandler(ConnectException.class)
	  public ResponseEntity<ErrorCode> handleDatbaseException(ConnectException exx, WebRequest request) {
		ErrorCode message = new ErrorCode();
		message.setCode("08001");
		message.setMessage("Database Unavailable Please try After some time");
	    return new ResponseEntity<ErrorCode>(message,HttpStatus.INTERNAL_SERVER_ERROR);
	  }

}
