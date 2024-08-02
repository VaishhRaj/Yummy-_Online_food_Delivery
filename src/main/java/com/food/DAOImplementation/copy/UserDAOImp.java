package com.food.DAOImplementation.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.UserInterface;
import com.food.model.User;

public class UserDAOImp implements UserInterface{
	Connection con=null;
	Statement stmt1=null;
	PreparedStatement prestmt=null;
	ResultSet res=null;
	public UserDAOImp()
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
	public int addUser(User user) {
		String query="Insert into `user`(`username`,`password`,`email`,`address`,`role`) values(?,?,?,?,?)";
		try 
		{
			prestmt=con.prepareStatement(query);
			prestmt.setString(1,user.getUserName());
			prestmt.setString(2,user.getPassword());
			prestmt.setString(3,user.getEmail());
			prestmt.setString(4,user.getAddress());
			prestmt.setString(5,user.getRole());
			
			return prestmt.executeUpdate();
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public User getUser(String email) {
		String query="Select * from `user` where `email`=?";
		User user=null;
		
		try {
			prestmt=con.prepareStatement(query);
			prestmt.setString(1,email);
			res=prestmt.executeQuery();
			if(res.next())
			{
				user=userDetails(res);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user);
		return user;
	}

	private User userDetails(ResultSet res) throws SQLException {
		User user=new User();
		
		user.setUserId(res.getInt("userid"));
		user.setUserName(res.getString("username"));
		user.setPassword(res.getString("password"));
		user.setEmail(res.getString("email"));
		user.setAddress(res.getString("address"));
		user.setRole(res.getString("role"));
		System.out.println(user);
		return user;
	}

	@Override
	public void updateUser(User user) {
		String qry="update `user` set `username`=?,`password`=?,`email`=?,`address`=?,`role`=? where `userid`=?";
		try {
			prestmt=con.prepareStatement(qry);
			prestmt.setString(1,user.getUserName());
			prestmt.setString(2,user.getPassword());
			prestmt.setString(3,user.getEmail());
			prestmt.setString(4,user.getAddress());
			prestmt.setString(5,user.getRole());
			prestmt.setInt(6, user.getUserId());
			
			prestmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteUser(int userId) {
		String delQuery="delete from `user` where `userid`=?";
		try {
			prestmt=con.prepareStatement(delQuery);
			prestmt.setInt(1, userId);
			
			prestmt.executeUpdate();
			System.out.println("Deleted Successfully!!");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	public List<User> getAllUser() {
		List<User> allUser=new ArrayList();
		String selQuery="Select * from `user`";
		User u=null;
		try {
			stmt1=con.createStatement();
			res=stmt1.executeQuery(selQuery);
			while(res.next())
			{
				u=userDetails(res);
				allUser.add(u);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return allUser;
	}

}
