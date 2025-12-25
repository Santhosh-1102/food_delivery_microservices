package com.delivery.service;

import java.awt.Taskbar.State;

import com.delivery.dto.DeliveryAssignmentDTO;
import com.delivery.model.DeliveryStatus;

public interface DeliveryService {

	DeliveryAssignmentDTO assignDeliveryToPatner(Integer orderId);
	
	DeliveryAssignmentDTO updateDeliveryStatus(Integer orderId,DeliveryStatus status);
}
