package com.food.DAO;

import java.util.List;

import com.food.model.Menu;

public interface MenuInterface {
	void addMenu(Menu menu);
	Menu getMenuByRestaurant(int menuId);
	void updateMenu(Menu menu);
	void deleteMenu(int menuId);
	List<Menu> getAllMenusByRestaurant(int resId);
}
