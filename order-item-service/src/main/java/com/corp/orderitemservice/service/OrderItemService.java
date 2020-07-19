package com.corp.orderitemservice.service;

import com.corp.orderitemservice.dto.CreateOrderItemDto;
import com.corp.orderitemservice.entity.OrderItem;

public interface OrderItemService {

	public String createOrderItem(CreateOrderItemDto createOrderItemDto);

	public OrderItem getOrderItem(String productCode);

}