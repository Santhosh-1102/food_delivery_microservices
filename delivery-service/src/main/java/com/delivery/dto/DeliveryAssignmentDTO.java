package com.delivery.dto;

import java.time.LocalDateTime;

import com.delivery.model.DeliveryStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAssignmentDTO {

private Integer assignmentId;
	
	private Integer orderId;
	
	private Integer patnerId;
	
	private DeliveryStatus status;
	
	private LocalDateTime assignedAt;
}
