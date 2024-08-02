package com.food.model;

public class OrderItem {
	private int orderItemId;
	private int orderId;
	private int menuId;
	private String itemName;
	private int quantity;
	private double itemTotal;
	public OrderItem() {
		super();
	}
	public OrderItem( int orderId, int menuId, int quantity, double itemTotal) {
		super();
		//this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getItemTotal() {
		return itemTotal;
	}
	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	@Override
	public String toString() {
		return "OrderItem \nrderItemId : " + orderItemId + "\norderId : " + orderId + "\nmenuId : " + menuId + "\nquantity : "
				+ quantity + "\nitemTotal : " + itemTotal;
	}
	
	

}
