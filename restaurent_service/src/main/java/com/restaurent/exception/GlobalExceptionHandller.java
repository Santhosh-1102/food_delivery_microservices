package com.restaurent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.restaurent.utils.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandller {

	@ExceptionHandler(RestaurentException.class)
	public ResponseEntity<ApiResponse<String>> handlerNotfoundException(RestaurentException ex){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(ApiResponse.failure(ex.getMessage()));
	}
	
	@ExceptionHandler(FoodNotFoundException.class)
	public ResponseEntity<ApiResponse<String>> foodItemNotfoundException(FoodNotFoundException ex){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(ApiResponse.failure(ex.getMessage()));
	}
}
