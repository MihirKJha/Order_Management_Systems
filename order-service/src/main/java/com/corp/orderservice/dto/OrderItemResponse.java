package com.corp.orderservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderItemResponse {
	private String productCode;
	private String productName;
	private int quantity;
}
