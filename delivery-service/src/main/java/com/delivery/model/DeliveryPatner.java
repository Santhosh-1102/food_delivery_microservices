package com.delivery.model;

import jakarta.persistence.Entity;
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
@Table(name = "delivery_patner")
public class DeliveryPatner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer patnerId;
	
	private String patrnerName;
	
	private String patnerPhone;
	
	private Boolean available=true;
}
