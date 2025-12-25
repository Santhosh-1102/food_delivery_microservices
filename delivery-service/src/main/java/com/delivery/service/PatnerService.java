package com.delivery.service;

import org.springframework.stereotype.Component;

import com.delivery.dto.PatnerDTO;

@Component
public interface PatnerService {

	PatnerDTO createPatner(PatnerDTO patnerDTO);
}
