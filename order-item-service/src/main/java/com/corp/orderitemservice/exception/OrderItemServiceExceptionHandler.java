package com.corp.orderitemservice.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class OrderItemServiceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = OrderItemNotFoundException.class)
	public ResponseEntity<Object> handleOrderItemNotFound(OrderItemNotFoundException exception) {
		return new ResponseEntity<>("Order Item not found", HttpStatus.NOT_FOUND);
	}

}