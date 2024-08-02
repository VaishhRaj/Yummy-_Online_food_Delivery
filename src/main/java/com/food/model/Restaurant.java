package com.food.model;

public class Restaurant {
	private int restaurantId;
	private String restaurantName;
	private String cuisineType;
	private int deliveryTime;
	private String address;
	private int adminUserId;
	private double rating;
	private boolean isActive;
	private String imagePath;
	public Restaurant(String restaurantName, String cuisineType, int deliveryTime, String address,
			double rating, boolean isActive,String imagePath) {
		super();
		//this.restaurantId=restaurantId;
		this.restaurantName = restaurantName;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.address = address;
		//this.adminUserId = adminUserId;
		this.rating = rating;
		this.isActive = isActive;
		this.imagePath=imagePath;
	}
	public Restaurant() {
		super();
	}
	
	
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public int getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAdminUserId() {
		return adminUserId;
	}
	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getImagePath()
	{
		return imagePath;
	}
	public void setImagePath(String imagePath)
	{
		this.imagePath=imagePath;
	}
	@Override
	public String toString() {
		return "Restaurant \nrestaurantId : " + restaurantId + "\nrestaurantName : " + restaurantName + "\n cuisineType :"
				+ cuisineType + "\n deliveryTime : " + deliveryTime + "\n address : " + address + "\n adminUserId : "
				+ adminUserId + "\n rating : " + rating + "\n isActive : " + isActive + "\n imagePath : " + imagePath;
	}
	
	
	

}
