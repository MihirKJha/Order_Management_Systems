package com.corp.orderitemservice.service;

import com.corp.orderitemservice.dto.CreateOrderItemRequest;
import com.corp.orderitemservice.entity.OrderItem;

public interface OrderItemService {

	public String createOrderItem(CreateOrderItemRequest createOrderItemDto);

	public OrderItem getOrderItem(String productCode);

}