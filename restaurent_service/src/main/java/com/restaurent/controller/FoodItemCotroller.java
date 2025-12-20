package com.restaurent.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurent.dto.FoodItemDTO;
import com.restaurent.service.FoodItemService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/fooditem")
@AllArgsConstructor
public class FoodItemCotroller {

	
	private final FoodItemService foodItemService;
	
	@PostMapping("{restaurentId}")
	public ResponseEntity<FoodItemDTO> addFoodItemToRestaurent(
									@PathVariable Integer restaurentId
									,@RequestBody FoodItemDTO foodItemDTO){
		FoodItemDTO foodItemToRestaurent = foodItemService.addFoodItemToRestaurent(restaurentId, foodItemDTO);
		return new ResponseEntity<FoodItemDTO>(foodItemToRestaurent,HttpStatus.CREATED);
		
	}
	
	@GetMapping("{foodItemId}")
	public ResponseEntity<FoodItemDTO> getFoodItemById(@PathVariable Integer foodItemId){
		FoodItemDTO foodItemById = foodItemService.getFoodItemById(foodItemId);
		return new ResponseEntity<FoodItemDTO>(foodItemById,HttpStatus.OK);
	}
}
