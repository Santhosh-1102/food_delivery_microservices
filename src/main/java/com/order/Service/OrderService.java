package com.order.Service;

import com.order.dto.OrderDTO;
import com.order.dto.OrderRequest;
import com.order.dto.RestaurentDTO;

public interface OrderService {
	
	RestaurentDTO validateRestaurant(Integer restaurantId);
	
	OrderDTO getMenu(Integer restaurentId,OrderRequest request);
}
