package com.corp.orderservice.service;

import java.util.Comparator;
import java.util.Date;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corp.orderservice.dto.CreateOrderRequest;
import com.corp.orderservice.dto.OrderItemResponse;
import com.corp.orderservice.entity.Orders;
import com.corp.orderservice.exception.OrderItemNotFoundException;
import com.corp.orderservice.proxy.OrderItemServiceProxy;
import com.corp.orderservice.repository.OrderRepository;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemServiceProxy orderItemServiceProxy;

	private static final String error = "Product not found ";

	@Override
	public String createOrder(CreateOrderRequest createOrderDto) {
		log.info("createOrderDto inside createOrder  " + createOrderDto);

		OrderItemResponse orderItem = orderItemServiceProxy.retrieveOrderItem(createOrderDto.getProductCode());

		if (StringUtils.isBlank(orderItem.getProductCode())) {
			throw new OrderItemNotFoundException(error + createOrderDto.getProductCode());
		}

		Optional<Orders> optOrder = orderRepository.findAll().stream()
				.max(Comparator.comparing(Orders::getOrderNumber));
		long orderNumber = Long.MAX_VALUE;

		if (optOrder.isPresent()) {
			orderNumber = optOrder.get().getOrderNumber() + 1;
		} else {
			orderNumber = 1;
		}

		Orders order = new Orders();
		order.setOrderDate(new Date());
		order.setProductCode(createOrderDto.getProductCode());
		order.setOrderNumber(orderNumber);
		order.setCustomerName(createOrderDto.getCustomerName());
		order.setShippingAddress(createOrderDto.getShippingAddress());
		order.setTotal(createOrderDto.getTotal());

		orderRepository.save(order);

		return String.valueOf(order.getOrderNumber());
	}

	@Override
	public Orders getOrder(Long orderNumber) {
		log.info("OrderNumber inside getOrderItem  " + orderNumber);

		return orderRepository.findByOrderNumber(orderNumber);

	}
}