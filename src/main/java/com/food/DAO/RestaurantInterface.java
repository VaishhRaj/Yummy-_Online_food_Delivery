package com.food.DAO;

import java.util.List;


import com.food.model.Restaurant;

public interface RestaurantInterface {
	void addRestaurant(Restaurant re);
	Restaurant getRestaurant(int resId);
	void updateRestaurant(Restaurant res);
	void deleteRestaurant(int resId);
	List<Restaurant> getAllRestaurant();
	

}
