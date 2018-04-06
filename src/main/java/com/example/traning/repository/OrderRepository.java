package com.example.traning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.traning.domain.Order;

public interface OrderRepository  extends JpaRepository<Order, Long> {


	Order findByOrderId(Integer orderId);

	

}
