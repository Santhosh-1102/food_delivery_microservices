package com.restaurent.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurent.dto.FoodItemDTO;
import com.restaurent.exception.FoodNotFoundException;
import com.restaurent.exception.ResourceAlredyExistException;
import com.restaurent.exception.RestaurentException;
import com.restaurent.model.FoodItem;
import com.restaurent.model.Restaurent;
import com.restaurent.repository.FoodItemRepo;
import com.restaurent.repository.RestaurentRepo;
import com.restaurent.service.FoodItemService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodItemImplementation implements FoodItemService{


	private final FoodItemRepo foodItemRepo;
	private final RestaurentRepo restaurentRepo;

   
	
	@Override
	public FoodItemDTO addFoodItemToRestaurent(
	        Integer restaurentId, FoodItemDTO itemDTO) {

	    Restaurent restaurent = restaurentRepo
	            .findById(restaurentId)
	            .orElseThrow(() ->
	                new RestaurentException("Restaurant Id is not present in the DB")
	            );

	    if (foodItemRepo.existsByNameAndRestaurentId(
	            itemDTO.getName(), restaurentId)) {

	        throw new ResourceAlredyExistException(
	                "Food item already exists in the restaurant"
	        );
	    }

	    FoodItem foodItem = FoodItem.builder()
	            .name(itemDTO.getName())
	            .description(itemDTO.getDescription())
	            .price(itemDTO.getPrice())
	            .available(itemDTO.getAvailable())
	            .category(itemDTO.getCategory())
	            .restaurent(restaurent)
	            .build();

	    FoodItem savedFoodItem = foodItemRepo.save(foodItem);

	    return mapToResponse(savedFoodItem);
	}

	public FoodItemDTO mapToResponse(FoodItem foodItem) {
	    return FoodItemDTO.builder()
	    		.id(foodItem.getId())
	            .name(foodItem.getName())
	            .description(foodItem.getDescription())
	            .price(foodItem.getPrice())
	            .available(foodItem.getAvailable())
	            .category(foodItem.getCategory())
	            .build();
	}

	@Override
	public List<FoodItemDTO> getMenu(Integer id) {
	
		Restaurent restaurent = restaurentRepo.findById(id).orElseThrow(()->new RestaurentException("Restaurent Id is not present"+id));
		List<FoodItem> foodItems = foodItemRepo.findByRestaurentId(id);
		return foodItems.stream()
				.map(this::mapToResponse)
				.toList();
	}

	@Override
	public FoodItemDTO getFoodItemById(Integer id) {
		FoodItem foodItem = foodItemRepo.findById(id).orElseThrow(()->new FoodNotFoundException("Food Item Id is not present"));
		return mapToResponse(foodItem);
	}

	

}
