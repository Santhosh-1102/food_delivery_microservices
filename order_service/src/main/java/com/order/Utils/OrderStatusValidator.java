package com.order.Utils;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.order.model.OrderStatus;

@Component
public class OrderStatusValidator {


	    private static final Map<OrderStatus, List<OrderStatus>> allowedTransitions =
	    		Map.of(
	    			    OrderStatus.CONFIRMED, List.of(OrderStatus.PREPARING, OrderStatus.CANCELLED),
	    			    OrderStatus.PREPARING, List.of(OrderStatus.OUT_FOR_DELIVERY),
	    			    OrderStatus.OUT_FOR_DELIVERY, List.of(OrderStatus.DELIVERED),
	    			    OrderStatus.DELIVERED, List.of(),
	    			    OrderStatus.CANCELLED, List.of()
	    			);

	    public boolean isValid(OrderStatus current, OrderStatus next) {
	        return allowedTransitions.getOrDefault(current, List.of())
	                                 .contains(next);
	    }
	    
	    
	    
	}

