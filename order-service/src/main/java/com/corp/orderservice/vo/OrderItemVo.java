package com.corp.orderservice.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderItemVo {
	private String productCode;
	private String productName;
	private int quantity;
}
