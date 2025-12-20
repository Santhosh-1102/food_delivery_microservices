package com.order.dto;

import lombok.Data;

@Data
public class RestaurentDTO {
	private Integer id;                 
    private String name;
    private String location;
    private Boolean open;
}
