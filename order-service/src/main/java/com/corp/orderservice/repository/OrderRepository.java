package com.corp.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corp.orderservice.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
	public Orders findByOrderNumber(Long orderNumber);
}
