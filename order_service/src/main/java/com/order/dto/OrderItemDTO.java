package com.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDTO {

	
	 private Long OrderItemId;

	    private Long orderId;

	    private Long foodItemId;

	    private Integer quantity;

	    private Double price;
}
