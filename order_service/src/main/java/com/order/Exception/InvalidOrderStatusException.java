package com.order.Exception;

public class InvalidOrderStatusException extends RuntimeException{

	public InvalidOrderStatusException(String s) {
		super(s);
	}

}
