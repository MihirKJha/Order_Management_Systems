package com.corp.orderitemservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.corp.orderitemservice.entity.OrderItem;

@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "order-item-service")
public interface OrderItemServiceProxy {

	@GetMapping("/order-item-service/retrieveOrderItem/{productCode}")
	public OrderItem retrieveOrderItem(@PathVariable String productCode);
}