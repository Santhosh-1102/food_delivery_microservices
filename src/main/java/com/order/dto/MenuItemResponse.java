package com.order.dto;

import lombok.Data;

@Data
public class MenuItemResponse {

	  	private Integer id;
	    private String name;
	    private Double price;
	    private Boolean available;
}
