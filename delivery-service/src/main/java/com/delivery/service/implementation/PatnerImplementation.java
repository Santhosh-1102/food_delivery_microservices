package com.delivery.service.implementation;

import org.springframework.stereotype.Service;

import com.delivery.dto.PatnerDTO;
import com.delivery.model.DeliveryPatner;
import com.delivery.repository.DeliveryPatnerRepo;
import com.delivery.service.PatnerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatnerImplementation implements PatnerService{

	private final DeliveryPatnerRepo deliveryPatnerRepo;
	
	@Override
	public PatnerDTO createPatner(PatnerDTO patnerDTO) {
		DeliveryPatner patner = deliveryPatnerRepo.save(makeDeliveryPatner(patnerDTO));
		return makeDeliveryPatnerDTO(patner);
	}
	
	private DeliveryPatner  makeDeliveryPatner(PatnerDTO dto) {
		return new DeliveryPatner(
				dto.getPatnerId(),
				dto.getPatrnerName(),
				dto.getPatnerPhone(),
				dto.getAvailable()
				);
	}
	private PatnerDTO  makeDeliveryPatnerDTO(DeliveryPatner patner) {
		return new PatnerDTO(
				patner.getPatnerId(),
				patner.getPatrnerName(),
				patner.getPatnerPhone(),
				patner.getAvailable()
				);
	}

}
