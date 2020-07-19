package com.corp.orderservice.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corp.orderservice.dto.CreateOrderDto;
import com.corp.orderservice.entity.Order;
import com.corp.orderservice.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/order")
@Api("Rest controller for order")
@Log4j
public class OrderController {

	@Autowired
	private OrderService orderService;

	@ApiOperation("API to create order")
	@PostMapping("/createOrder")
	public String createOrder(@RequestBody @NotNull CreateOrderDto createOrderDto) {
		return orderService.createOrder(createOrderDto);

	}

	@ApiOperation("API to retrieve order")
	@GetMapping("/retrieveOrder/{orderNumber}")
	public Order retrieveOrder(@PathVariable String orderNumber) {
		return orderService.getOrder(orderNumber);

	}
}