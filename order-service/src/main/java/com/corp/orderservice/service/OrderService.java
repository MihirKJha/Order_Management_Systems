package com.corp.orderservice.service;

import com.corp.orderservice.dto.CreateOrderRequest;
import com.corp.orderservice.entity.Orders;

public interface OrderService {

	public String createOrder(CreateOrderRequest createOrderDto);

	public Orders getOrder(Long orderNumber);

}