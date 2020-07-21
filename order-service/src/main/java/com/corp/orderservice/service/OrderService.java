package com.corp.orderservice.service;

import com.corp.orderservice.dto.CreateOrderDto;
import com.corp.orderservice.entity.Orders;

public interface OrderService {

	public String createOrder(CreateOrderDto createOrderDto);

	public Orders getOrder(Long orderNumber);

}