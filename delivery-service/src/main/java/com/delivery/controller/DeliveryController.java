package com.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.dto.DeliveryAssignmentDTO;
import com.delivery.dto.DeliveryStatusDTO;
import com.delivery.service.DeliveryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/delivery")
@RequiredArgsConstructor
public class DeliveryController {

	private final DeliveryService deliveryService;
	
	@PostMapping("/assign/{orderId}")
	public ResponseEntity<DeliveryAssignmentDTO> assignDeliveryPatner(@PathVariable Integer orderId){
		return ResponseEntity.ok(deliveryService.assignDeliveryToPatner(orderId));
	}
	
	@PostMapping("/update-status/{orderId}/status")
	public ResponseEntity<DeliveryAssignmentDTO> updateOrderStatus(
										@PathVariable Integer orderId,
										@RequestBody DeliveryStatusDTO status){
		
		return ResponseEntity.ok(deliveryService.updateDeliveryStatus(orderId, status.getStatus()));
	}
}
