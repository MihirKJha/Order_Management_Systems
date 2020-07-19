package com.corp.orderitemservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corp.orderitemservice.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	public OrderItem findByProductCode(String productCode);
}
