package com.food.DAO;

import java.util.List;

import com.food.model.OrderHistory;

public interface OrderHistoryInterface {
	void addOrderHistory(OrderHistory order);
	OrderHistory getOrderHistory(int orderHisId);
	void updateOrderHistory(OrderHistory order);
	void deleteOrderHistory(int orderHisId);
	List<OrderHistory> getOrderHistoriesByUser(int userId);
}
