package com.restaurent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurent.model.FoodItem;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem, Integer>{

	boolean existsByNameAndRestaurentId(String name, Integer restaurantId);
	
	List<FoodItem> findByRestaurentId(Integer id);
	
//	@Query("SELECT f FROM FoodItem f WHERE LOWER(f.name) LIKE LOWER(CONCAT('%', :name, '%'))")
//	List<FoodItem> searchByFoodName(String name);

}
