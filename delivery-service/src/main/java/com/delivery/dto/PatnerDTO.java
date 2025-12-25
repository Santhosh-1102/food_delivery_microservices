package com.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class PatnerDTO {

private Integer patnerId;
	
	private String patrnerName;
	
	private String patnerPhone;
	
	private Boolean available=true;
}
