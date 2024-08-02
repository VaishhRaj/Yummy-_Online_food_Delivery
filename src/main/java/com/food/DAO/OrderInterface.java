package com.food.DAO;

import java.util.List;

import com.food.model.Order;

public interface OrderInterface {
	void addOrder(Order order);
	Order getOrder(int orderId);
	void updateOrder(Order order);
	void deleteOrder(int orderid);
	//int getOrderId();
	List<Order> getAllOrderByUser(int userId);
	

}
