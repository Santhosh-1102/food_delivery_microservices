package com.order.dto;

import java.time.LocalDateTime;

import com.order.model.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderHistoryDTO {

	private OrderStatus status;
	private LocalDateTime changedAt;
}
