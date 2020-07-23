package com.corp.orderitemservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corp.orderitemservice.dto.CreateOrderItemRequest;
import com.corp.orderitemservice.entity.OrderItem;
import com.corp.orderitemservice.repository.OrderItemRepository;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public String createOrderItem(CreateOrderItemRequest createOrderItemDto) {
		log.info("createOrderItemDto inside createOrderItem " + createOrderItemDto);

		OrderItem orderItem = new OrderItem();
		orderItem.setProductCode(createOrderItemDto.getProductCode());
		orderItem.setProductName(createOrderItemDto.getProductName());
		orderItem.setQuantity(createOrderItemDto.getQuantity());

		orderItemRepository.save(orderItem);

		return orderItem.getProductCode();
	}

	@Override
	public OrderItem getOrderItem(String productCode) {
		log.info("productCode inside getOrderItem  " + productCode);

		return orderItemRepository.findByProductCode(productCode);
	}

}