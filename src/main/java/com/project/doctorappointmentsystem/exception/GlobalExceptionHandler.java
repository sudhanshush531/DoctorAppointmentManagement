package com.project.doctorappointmentsystem.exception;

import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@RestController
@Log4j2
public class GlobalExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ErrorInfo> handleNotFoundException(NotFoundException ex, WebRequest request) {
//		log.error("Exception {} for {}", ex.getLocalizedMessage(), request.getContextPath());
		ErrorInfo errorEnfo = new ErrorInfo(new Date(), ex.getMessage(), request.getDescription(false),
				HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorEnfo, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> illegalArgumentException(IllegalArgumentException ex, WebRequest request) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<ErrorInfo> genericException(Exception ex, HttpServletRequest request) {
//		log.error("Exception {} for {}", ex.getLocalizedMessage(), request.getRequestURI());
		return new ResponseEntity<>(
				ErrorInfo.builder().message(ex.getLocalizedMessage())
						.message(HttpStatus.INTERNAL_SERVER_ERROR.toString()).details(request.getRequestURI()).build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<ErrorInfo> genericException(MethodArgumentNotValidException ex, WebRequest request) {
//		log.error("Exception {} for {}", ex.getLocalizedMessage(), request.getContextPath());
		return new ResponseEntity<>(
				ErrorInfo.builder().timestamp(new Date()).details(ex.getBindingResult().toString())
						.message("Method Argument Invalid").status(HttpStatus.BAD_REQUEST.value()).build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
