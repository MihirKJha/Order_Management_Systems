package com.corp.orderservice.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateOrderRequest {
	@NotEmpty
	private String customerName;
	@NotNull
	private Date orderDate;
	@NotEmpty
	private String shippingAddress;
	@NotEmpty
	private String productCode;
	@NotNull
	private long total;
}
