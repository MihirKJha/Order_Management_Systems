package com.corp.orderservice.service;

import java.util.Comparator;
import java.util.Date;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corp.orderservice.dto.CreateOrderDto;
import com.corp.orderservice.entity.Order;
import com.corp.orderservice.exception.OrderItemNotFoundException;
import com.corp.orderservice.proxy.OrderItemServiceProxy;
import com.corp.orderservice.repository.OrderRepository;
import com.corp.orderservice.vo.OrderItemVo;

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

		OrderItemVo orderItem = orderItemServiceProxy.retrieveOrderItem(createOrderDto.getProductCode());

		if (StringUtils.isBlank(orderItem.getProductCode())) {
			throw new OrderItemNotFoundException("Product not found " + createOrderDto.getProductCode());
		}

		Optional<Order> optOrder = orderRepository.findAll().stream().max(Comparator.comparing(Order::getOrderNumber));
		long orderNumber = Long.MAX_VALUE;

		if (optOrder.isPresent()) {
			orderNumber = optOrder.get().getOrderNumber();
		} else {
			orderNumber = 1;
		}

		Order order = new Order();
		order.setOrderDate(new Date());
		order.setOrderItem(createOrderDto.getProductCode());
		order.setOrderNumber(orderNumber++);
		order.setShippingAddress(createOrderDto.getShippingAddress());
		order.setTotal(createOrderDto.getTotal());

		orderRepository.save(order);

		return String.valueOf(order.getOrderNumber());
	}

	@Override
	public Order getOrder(String orderNumber) {
		log.info("OrderNumber inside getOrderItem  " + orderNumber);

		return orderRepository.findByOrderNumber(orderNumber);

	}
}