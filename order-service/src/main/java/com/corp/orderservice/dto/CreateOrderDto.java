package com.corp.orderservice.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateOrderDto {
	@NotEmpty
	private String customerName;
	@NotEmpty
	private Date orderDate;
	@NotEmpty
	private String shippingAddress;
	@NotEmpty
	private String productCode;
	@NotEmpty
	private long total;
}
