package com.corp.orderservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.corp.orderservice.vo.OrderItemVo;

@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "order-item-service")
public interface OrderItemServiceProxy {

	@GetMapping(value = "/order-item-service/orderItem/retrieveOrderItem/{productCode}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public OrderItemVo retrieveOrderItem(@PathVariable("productCode") String productCode);
}