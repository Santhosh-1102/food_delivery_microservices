package com.order.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.Service.OrderService;
import com.order.dto.OrderDTO;
import com.order.dto.OrderHistoryDTO;
import com.order.dto.OrderRequest;
import com.order.dto.OrderStatusDTO;
import com.order.model.Order;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;
	
	@PostMapping("/place/{restaurentId}")
	public ResponseEntity<OrderDTO> placeOrder(@PathVariable Integer restaurentId,@RequestBody OrderRequest request) {
		OrderDTO orderDTO = orderService.getMenu(restaurentId, request);
		return new ResponseEntity<OrderDTO>(orderDTO,HttpStatus.CREATED);
	}
	
	@GetMapping("/fetch-order/{orderId}")
	public ResponseEntity<OrderDTO> fetchOrder(@PathVariable Integer orderId){
		OrderDTO orderById = orderService.getOrderById(orderId);
		return new ResponseEntity<OrderDTO>(orderById,HttpStatus.OK);
	}
	
	@PutMapping("/{orderId}/status")
	public ResponseEntity<Order> updateOrderStatus(
									@PathVariable Integer orderId,
									@RequestBody OrderStatusDTO status){
		Order orderStatus = orderService.updateOrderStatus(orderId, status.getStatus());
		return new ResponseEntity<Order>(orderStatus,HttpStatus.OK);
	}
	
	@GetMapping("/{orderId}/status-history")
	public ResponseEntity<List<OrderHistoryDTO>> getOrderStatusHistory(@PathVariable Integer orderId){
		List<OrderHistoryDTO> orderStatusHistory = orderService.getOrderStatusHistory(orderId);
		return ResponseEntity.ok(orderStatusHistory);		
	}
	
}
