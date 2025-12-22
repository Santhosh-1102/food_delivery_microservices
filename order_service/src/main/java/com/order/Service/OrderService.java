package com.order.Service;

import java.util.List;

import com.order.dto.OrderDTO;
import com.order.dto.OrderHistoryDTO;
import com.order.dto.OrderRequest;
import com.order.dto.RestaurentDTO;
import com.order.model.Order;
import com.order.model.OrderStatus;

public interface OrderService {
	
	RestaurentDTO validateRestaurant(Integer restaurantId);
	
	OrderDTO getMenu(Integer restaurentId,OrderRequest request);
	
	OrderDTO getOrderById(Integer orderId);
	
	Order updateOrderStatus(Integer orderId,OrderStatus status);
	
	List<OrderHistoryDTO> getOrderStatusHistory(Integer orderId);

}
