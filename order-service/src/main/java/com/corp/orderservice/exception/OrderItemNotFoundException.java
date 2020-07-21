package com.corp.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderItemNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderItemNotFoundException(String message) {
		super(message);
	}
}