package com.delivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.delivery.utils.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DeliveryPatnerIsNotAvailableException.class)
	public ResponseEntity<ApiResponse> handlePatnerIdException(DeliveryPatnerIsNotAvailableException ex) {
		return  ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(new ApiResponse(false, ex.getMessage()));
	}
}
