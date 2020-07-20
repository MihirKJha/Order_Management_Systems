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
	public ResponseEntity<Object> handleOrderItemNotFound(OrderItemNotFoundException ex) {
		OrderMangementExceptionSchema exceptionReposne = new OrderMangementExceptionSchema(ex.getMessage(),
				ex.getCause());
		return new ResponseEntity<>(exceptionReposne, HttpStatus.NOT_FOUND);
	}

}