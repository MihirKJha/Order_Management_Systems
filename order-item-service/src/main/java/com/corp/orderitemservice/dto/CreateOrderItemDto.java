package com.corp.orderitemservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateOrderItemDto {
	private String productCode;
	private String productName;
	private int quantity;
}
