package com.food.DAOImplementation.copy;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.RestaurantInterface;
import com.food.model.Restaurant;


public class RestaurantDAOImp implements RestaurantInterface{
	Connection con=null;
	Statement stmt1=null;
	PreparedStatement prestmt=null;
	ResultSet res=null;
	public RestaurantDAOImp()
	{
		String url="jdbc:mysql://localhost:3306/online_fooddelivery";
		String user="root";
		String pwd="vaishRaj9*";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addRestaurant(Restaurant re) {
		String query="Insert into `restaurant`(`restaurantId`,`name`,`cuisineType`,`deliveryTime`,`address`,`adminUserId`,`rating`,`isActive`,`imagepath`) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		try {
			prestmt=con.prepareStatement(query);
			prestmt.setInt(1,re.getRestaurantId());
			prestmt.setString(2,re.getRestaurantName());
			prestmt.setString(3,re.getCuisineType());
			prestmt.setInt(4,re.getDeliveryTime());
			prestmt.setString(5,re.getAddress());
			prestmt.setInt(6,re.getAdminUserId());
			prestmt.setDouble(7, re.getRating());
			prestmt.setString(8,re.getImagePath());
			prestmt.setBoolean(9, re.isActive());
			
			prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Restaurant getRestaurant(int resId) {
		String query="Select * from `restaurant` where `restaurantId`=?";
		Restaurant restaurant=null;
		
		try {
			prestmt=con.prepareStatement(query);
			prestmt.setInt(1,resId);
			res=prestmt.executeQuery();
			if(res.next())
			{
				restaurant=restaurantDetails(res);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return restaurant;
		
	}

	private Restaurant restaurantDetails(ResultSet res2) throws SQLException {
		Restaurant res=new Restaurant();
		res.setRestaurantId(res2.getInt("restaurantId"));
		res.setRestaurantName(res2.getString("name"));
		res.setCuisineType(res2.getString("cuisineType"));
		res.setDeliveryTime(res2.getInt("deliveryTime"));
		res.setAddress(res2.getString("address"));
		res.setAdminUserId(res2.getInt("adminUserId"));
		res.setRating(res2.getDouble("rating"));
		res.setActive(res2.getBoolean("isActive"));
		res.setImagePath(res2.getString("imagepath"));
		
		return res;
		
	}

	@Override
	public void updateRestaurant(Restaurant res) {
		String qry="update `restaurant` set `name`=?,`cuisineType`=?,`deliveryTime`=?,`address`=?,`adminUserId`=?,`rating`=?,`isActive`=?,`imagepath`=? where `restaurantid`=?";
		try {
			prestmt=con.prepareStatement(qry);
			prestmt.setString(1,res.getRestaurantName());
			prestmt.setString(2,res.getCuisineType());
			prestmt.setInt(3,res.getDeliveryTime());
			prestmt.setString(4,res.getAddress());
			prestmt.setInt(5,res.getAdminUserId());
			prestmt.setDouble(6, res.getRating());
			prestmt.setBoolean(7, res.isActive());
			prestmt.setString(8,res.getImagePath());
			prestmt.setInt(9,res.getRestaurantId());
			prestmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRestaurant(int resId) {
		String delQuery="delete from `restaurant` where `restaurantid`=?";
		try {
			prestmt=con.prepareStatement(delQuery);
			prestmt.setInt(1, resId);
			
			prestmt.executeUpdate();
			System.out.println("Deleted Successfully!!");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		List<Restaurant> allRestaurants=new ArrayList<Restaurant>();
		String selQuery="Select * from `restaurant`";
		Restaurant r=null;
		try {
			stmt1=con.createStatement();
			res=stmt1.executeQuery(selQuery);
			while(res.next())
			{
				r=restaurantDetails(res);
				allRestaurants.add(r);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allRestaurants;
	}

}
