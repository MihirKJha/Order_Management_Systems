package com.corp.orderservice.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corp.orderservice.dto.CreateOrderDto;
import com.corp.orderservice.entity.Orders;
import com.corp.orderservice.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/order")
@Api("Rest controller for order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@ApiOperation("API to create order")
	@PostMapping(value = "/createOrder", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createOrder(@RequestBody @Valid @NotNull CreateOrderDto createOrderDto) {
		return orderService.createOrder(createOrderDto);

	}

	@ApiOperation("API to retrieve order")
	@GetMapping(value = "/retrieveOrder/{orderNumber}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Orders retrieveOrder(@PathVariable @Valid String orderNumber) {
		return orderService.getOrder(Long.valueOf(orderNumber));

	}
}