package com.order.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.order.Utils.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ApiResponse> handleOrderNotFound(OrderNotFoundException ex){
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(new ApiResponse(false,ex.getMessage()));
	}
	
	@ExceptionHandler(OrderIdIsNotFoundException.class)
	public ResponseEntity<ApiResponse> handleOrderIdNotFound(OrderIdIsNotFoundException ex){
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(new ApiResponse(false,ex.getMessage()));
	}
	
	@ExceptionHandler(InvalidOrderStatusException.class)
	public ResponseEntity<ApiResponse> handleOrderStatus(InvalidOrderStatusException ex){
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(new ApiResponse(false,ex.getMessage()));
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGlobalException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse(false, "Something went wrong"));
    }
}

