package com.restaurent.service;

import java.util.List;

import com.restaurent.dto.FoodItemDTO;

public interface FoodItemService {
	
	FoodItemDTO addFoodItemToRestaurent(
	        Integer restaurentId,
	        FoodItemDTO itemDTO
	);
	
	List<FoodItemDTO> getMenu(Integer id);
	
	FoodItemDTO getFoodItemById(Integer id);
	
	
}
