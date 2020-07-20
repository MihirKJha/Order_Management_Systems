package com.corp.orderservice.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.corp.orderitemservice.exception.OrderMangementExceptionSchema;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class OrderServiceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = OrderNotFoundException.class)
	public ResponseEntity<Object> handleOrderNotFound(OrderNotFoundException ex) {
		OrderMangementExceptionSchema exceptionReposne = new OrderMangementExceptionSchema(ex.getMessage(),
				ex.getCause());
		return new ResponseEntity<>(exceptionReposne, HttpStatus.NOT_FOUND);
	}

}