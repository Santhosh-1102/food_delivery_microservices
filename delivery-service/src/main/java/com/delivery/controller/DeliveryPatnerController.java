package com.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.dto.PatnerDTO;
import com.delivery.service.PatnerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/patner")
public class DeliveryPatnerController {

	
	private final PatnerService patnerService;
	
	@PostMapping("/create-patner")
	public ResponseEntity<PatnerDTO> registerDeliveryPatner(@RequestBody PatnerDTO patnerDTO){
		
		return ResponseEntity.ok(patnerService.createPatner(patnerDTO));
	}
}
