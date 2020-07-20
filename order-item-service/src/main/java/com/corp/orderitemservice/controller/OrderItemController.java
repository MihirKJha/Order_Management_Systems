package com.corp.orderitemservice.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corp.orderitemservice.dto.CreateOrderItemDto;
import com.corp.orderitemservice.entity.OrderItem;
import com.corp.orderitemservice.service.OrderItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/orderItem")
@Api("Rest controller for order item")
public class OrderItemController {

	@Autowired
	private OrderItemService orderItemService;

	@ApiOperation("API to create order item")
	@PostMapping("/createOrder")
	public String createOrderItem(@RequestBody @Valid @NotNull CreateOrderItemDto createOrderItemDto) {
		return orderItemService.createOrderItem(createOrderItemDto);
	}

	@ApiOperation("API to retrieve order item")
	@GetMapping("/retrieveOrderItem/{productCode}")
	public OrderItem retrieveOrderItem(@PathVariable @Valid @NotNull String productCode) {
		return orderItemService.getOrderItem(productCode);
	}
}