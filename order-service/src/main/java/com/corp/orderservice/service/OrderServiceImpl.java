package com.corp.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corp.orderitemservice.proxy.OrderItemServiceProxy;
import com.corp.orderservice.dto.CreateOrderDto;
import com.corp.orderservice.entity.Order;
import com.corp.orderservice.repository.OrderRepository;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemServiceProxy orderItemServiceProxy;

	@Override
	public String createOrder(CreateOrderDto createOrderDto) {
		log.info("createOrderDto inside createOrder  " + createOrderDto);
j
		orderItemServiceProxy.retrieveOrderItem(createOrderDto.getProductCode());

		Order order = new Order();

		return orderRepository.save(order);

	}

	@Override
	public Order getOrder(String orderNumber) {
		log.info("OrderNumber inside getOrderItem  " + orderNumber);

		return orderRepository.findByOrderNumber(orderNumber);

	}
}