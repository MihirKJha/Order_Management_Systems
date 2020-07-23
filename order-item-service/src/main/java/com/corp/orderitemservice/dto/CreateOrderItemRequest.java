package com.corp.orderitemservice.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateOrderItemRequest {
	@NotEmpty
	private String productCode;
	@NotEmpty
	private String productName;
	@NotNull
	private int quantity;
}
