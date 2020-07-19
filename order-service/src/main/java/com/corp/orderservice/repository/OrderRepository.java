package com.corp.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corp.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	public Order findByOrderNumber(String orderNumber);
}
