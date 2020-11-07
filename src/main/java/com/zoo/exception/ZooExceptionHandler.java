/**
 * 
 */
package com.zoo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.zoo.dto.ErrorResponseDTO;

/**
 * Global Exception handler for Widget Store Service
 *
 */
@ControllerAdvice
public class ZooExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { AnimalNotFoundException.class })
	protected ResponseEntity<Object> handleConflict(AnimalNotFoundException ex, WebRequest request) {
		ErrorResponseDTO response = new ErrorResponseDTO();
		response.setMessage(ex.getLocalizedMessage());
		response.setStatus(HttpStatus.NOT_FOUND.value());
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler(value = { RoomNotFoundException.class })
	protected ResponseEntity<Object> handleConflict(RoomNotFoundException ex, WebRequest request) {
		ErrorResponseDTO response = new ErrorResponseDTO();
		response.setMessage(ex.getLocalizedMessage());
		response.setStatus(HttpStatus.NOT_FOUND.value());
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	

}
