package com.educandoweb.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.course.services.exceptions.DataBaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
//ele que vai antecipar as exceções que aconterecem pra que esse objeto execute o tratamento 
@ControllerAdvice 
public class ResourceExceptionHandler {
	//tratando exceção de nao encontrar id 
	@ExceptionHandler(ResourceNotFoundException.class)//o nome da exceção que será interceptada, esse metodo vai interceptar qualquer exceção do tipo que esta entre () 
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error,e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
	@ExceptionHandler(DataBaseException.class)//o nome da exceção que será interceptada, esse metodo vai interceptar qualquer exceção do tipo que esta entre () 
	public ResponseEntity<StandardError> dataBase(DataBaseException e, HttpServletRequest request){
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error,e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);

}
