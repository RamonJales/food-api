package br.com.food.controllers.exceptions.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.food.controllers.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handAll(Exception ex) {
		ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(),
				HttpStatus.BAD_REQUEST,
				ex.getMessage());
		response.getErrors().add(ex.getLocalizedMessage());
		
		ResponseEntity<ExceptionResponse> responseEntity =  new ResponseEntity<>(response, response.getStatus());
		
		return responseEntity;
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleNotFoundException(ResourceNotFoundException ex) {
		ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(),
				HttpStatus.NOT_FOUND,
				ex.getMessage());
		response.getErrors().add(ex.getMessage());
		
		ResponseEntity<ExceptionResponse> responseEntity = new ResponseEntity<>(response, response.getStatus());
		return responseEntity;
	}
}
