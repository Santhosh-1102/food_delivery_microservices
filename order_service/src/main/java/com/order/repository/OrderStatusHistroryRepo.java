package com.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.model.OrderStatusHistory;

public interface OrderStatusHistroryRepo extends JpaRepository<OrderStatusHistory, Integer>{

	 List<OrderStatusHistory> findByOrderIdOrderByChangedAtAsc(Integer orderId);
	
}
