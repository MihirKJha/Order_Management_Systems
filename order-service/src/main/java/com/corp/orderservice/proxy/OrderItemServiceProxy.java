package com.corp.orderservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.corp.orderservice.vo.OrderItemVo;

@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "order-item-service")
public interface OrderItemServiceProxy {

	@GetMapping("/order-item-service/retrieveOrderItem/{productCode}")
	public OrderItemVo retrieveOrderItem(String productCode);
}