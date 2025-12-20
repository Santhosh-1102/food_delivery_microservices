package com.restaurent.utils;

import org.springframework.stereotype.Component;

import com.restaurent.dto.FoodItemDTO;
import com.restaurent.model.FoodItem;

@Component
	public class FoodItemMapper {

	    public FoodItemDTO toDto(FoodItem foodItem) {
	        return FoodItemDTO.builder()
	                .name(foodItem.getName())
	                .description(foodItem.getDescription())
	                .price(foodItem.getPrice())
	                .available(foodItem.getAvailable())
	                .category(foodItem.getCategory())
	                .build();
	    }
	}
