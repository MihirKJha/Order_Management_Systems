package com.corp.orderitemservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class OrderMangementExceptionSchema {
	private String message;
	private Throwable details;
}
