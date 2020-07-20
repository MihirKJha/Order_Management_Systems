package com.corp.orderitemservice.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateOrderItemDto {
	@NotEmpty
	private String productCode;
	@NotEmpty
	private String productName;
	@NotEmpty
	private int quantity;
}
