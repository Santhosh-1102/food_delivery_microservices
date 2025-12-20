package com.order.dto;

import lombok.Data;

@Data
public class FoodItemDTO {

	private Integer id;
    private String name;

    private String description;

    private Double price;

    private Boolean available;
}
