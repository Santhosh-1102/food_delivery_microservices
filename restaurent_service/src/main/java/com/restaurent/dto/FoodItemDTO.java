package com.restaurent.dto;

import com.restaurent.model.FoodCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodItemDTO {

	private Integer id;
    private String name;

    private String description;

    private Double price;

    private Boolean available;

    private FoodCategory category;
}

