package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.model.OrderItems;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItems, Integer>{

}
