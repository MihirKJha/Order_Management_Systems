package com.corp.orderservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ORDER_INFO")
@Getter
@Setter
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ORDER_NUMBER")
	private Long orderNumber;

	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	@Column(name = "ORDER_DATE")
	private Date orderDate;

	@Column(name = "SHIPPING_ADDRESS")
	private String shippingAddress;

	@Column(name = "ORDER_ITEM")
	private String orderItem;

	@Column(name = "TOTAL")
	private long total;

}