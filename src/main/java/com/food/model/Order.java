package com.food.model;

import java.util.Date;

public class Order {
	private int orderId;
	private int userId;
	private int restaurantId;
	private Date orderDate;
	private double totalAmount;
	private String status;
	private String paymentMethod;
	public Order() {
		super();
	}
	public Order(int orderId, int userId, int restaurantId, Date orderDate, double totalAmount, String status,
			String paymentMethod) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMethod = paymentMethod;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	@Override
	public String toString() {
		return "Order \n orderId=" + orderId + "\n userId=" + userId + "\n restaurantId=" + restaurantId + "\n orderDate="
				+ orderDate + "\n totalAmount=" + totalAmount + "\n status=" + status + "\n paymentMethod=" + paymentMethod;
	}
	
	
	
	

}
