package com.corp.orderservice.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateOrderDto {
	private String customerName;
	private Date orderDate;
	private String shippingAddress;
	private String productCode;
	private long total;
}
