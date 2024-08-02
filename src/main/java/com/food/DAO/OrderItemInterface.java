package com.food.DAO;

import java.util.List;

import com.food.model.OrderItem;

public interface OrderItemInterface {
	void addOrderItem(OrderItem orderitem);
	OrderItem getOrderItem(int itemId);
	void updateOrderItem(OrderItem orderitem);
	void deleteOrderItem(int itemId);
	List<OrderItem> getOrderItemsByOrder(int orderId);
	

}
