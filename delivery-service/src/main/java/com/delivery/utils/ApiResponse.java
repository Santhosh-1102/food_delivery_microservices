package com.delivery.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse<T> {

	private boolean success;
    private String message;
    private T data;
    
    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
