package com.delivery.service.implementation;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.delivery.dto.DeliveryAssignmentDTO;
import com.delivery.dto.DeliveryStatusDTO;
import com.delivery.exception.DeliveryPatnerIsNotAvailableException;
import com.delivery.model.DeliveryAssignment;
import com.delivery.model.DeliveryPatner;
import com.delivery.model.DeliveryStatus;
import com.delivery.repository.DeliveryAssignmentRepo;
import com.delivery.repository.DeliveryPatnerRepo;
import com.delivery.service.DeliveryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImplementation implements DeliveryService{
	
	private final DeliveryAssignmentRepo assignmentRepo;
	
	private final DeliveryPatnerRepo patnerRepo;
	
	@Override
	public DeliveryAssignmentDTO assignDeliveryToPatner(Integer orderId) {
		DeliveryPatner deliveryPatner = patnerRepo
											.findFirstByAvailableTrue()
											.orElseThrow(()-> new DeliveryPatnerIsNotAvailableException("All Delevery Paatenrs are Not Available At this Movement ")
										);
		deliveryPatner.setAvailable(false);
		
		patnerRepo.save(deliveryPatner);
		
		DeliveryAssignment deliveryAssignment = new DeliveryAssignment();
		deliveryAssignment.setOrderId(orderId);
		deliveryAssignment.setPatnerId(deliveryPatner.getPatnerId());
		deliveryAssignment.setStatus(DeliveryStatus.ASSIGNED);
		deliveryAssignment.setAssignedAt(LocalDateTime.now());
		
		DeliveryAssignment deliveryAssigned = assignmentRepo.save(deliveryAssignment);
		
		return mapToDto(deliveryAssigned);
	}
	
	private DeliveryAssignmentDTO mapToDto(DeliveryAssignment assignment) {
	    return new DeliveryAssignmentDTO(
	        assignment.getAssignmentId(),
	        assignment.getOrderId(),
	        assignment.getPatnerId(),
	        assignment.getStatus(),
	        assignment.getAssignedAt()
	    );
	}

	@Override
	public DeliveryAssignmentDTO updateDeliveryStatus(Integer assginmentId, DeliveryStatus status) {
		DeliveryAssignment assignment = assignmentRepo.findById(assginmentId).orElseThrow(()->new RuntimeException("order is not available"));
		assignment.setStatus(status);
		
		if(status==DeliveryStatus.DELIVERED) {
			DeliveryPatner patner = patnerRepo.findById(assignment.getPatnerId())
					.orElseThrow(()->
							new DeliveryPatnerIsNotAvailableException("delivery patner is not available")
					);
			patner.setAvailable(true);
			patnerRepo.save(patner);
		}
		
		DeliveryAssignment deliveryAssignment = assignmentRepo.save(assignment);
		return mapToDto(deliveryAssignment);
	}


}
