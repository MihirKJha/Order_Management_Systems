package com.corp.orderservice.service;

import com.corp.orderservice.dto.CreateOrderDto;
import com.corp.orderservice.entity.Order;

public interface OrderService {

	public String createOrder(CreateOrderDto createOrderDto);

	public Order getOrder(String orderNumber);

}