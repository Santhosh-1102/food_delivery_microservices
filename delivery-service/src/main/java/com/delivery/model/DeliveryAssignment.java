package com.delivery.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "delivery_assignment")
public class DeliveryAssignment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer assignmentId;
	
	private Integer orderId;
	
	private Integer patnerId;
	
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;
	
	private LocalDateTime assignedAt;
}
