package com.food.DAO;

import java.util.List;

import com.food.model.User;

public interface UserInterface {
	public int addUser(User user);
	public User getUser(String email);
	public void updateUser(User user);
	public void deleteUser(int userId);
	List<User> getAllUser();
	

}
