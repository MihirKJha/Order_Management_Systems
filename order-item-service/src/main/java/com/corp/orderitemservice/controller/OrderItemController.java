package com.corp.orderitemservice.controller;

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

import com.corp.orderitemservice.dto.CreateOrderItemRequest;
import com.corp.orderitemservice.entity.OrderItem;
import com.corp.orderitemservice.service.OrderItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Rest controller for order item")
@RestController
@RequestMapping(value = "/orderItem",
	produces = MediaType.APPLICATION_JSON_VALUE,
	consumes = MediaType.APPLICATION_JSON_VALUE)
public class OrderItemController {

	@Autowired
	private OrderItemService orderItemService;

	@ApiOperation("API to create order item")
	@PostMapping
	public String createOrderItem(@RequestBody @NotNull CreateOrderItemRequest createOrderItemDto) {
		return orderItemService.createOrderItem(createOrderItemDto);
	}

	@ApiOperation("API to retrieve order item")
	@GetMapping("/{productCode}")
	@HystrixCommand(fallbackMethod = "fallbackOrderItem")
	public OrderItem retrieveOrderItem(@PathVariable("productCode") @Valid @NotNull String productCode) {
		return orderItemService.getOrderItem(productCode);
	}

	public OrderItem fallbackOrderItem(String productCode) {
		return new OrderItem();
	}

}