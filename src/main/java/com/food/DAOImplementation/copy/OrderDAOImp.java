package com.food.DAOImplementation.copy;

import java.sql.Connection;




import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.OrderInterface;
import com.food.model.Order;

public class OrderDAOImp implements OrderInterface{
	static Connection con=null;
	static Statement stmt1=null;
	PreparedStatement prestmt=null;
	static ResultSet res=null;
	public OrderDAOImp()
	{
		String url="jdbc:mysql://localhost:3306/online_fooddelivery";
		String user="root";
		String pwd="vaishRaj9*";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pwd);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void addOrder(Order order) {
		String query="Insert into `Order`(`orderId`,`userId`,`restaurantId`,`orderDate`,`totalAmount`,`status`,`paymentMethod`) "
				+ "values(?,?,?,?,?,?,?)";
		try {
			prestmt=con.prepareStatement(query);
			java.util.Date utilDate = order.getOrderDate();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			prestmt.setInt(1,getOrderId());
			prestmt.setInt(2,order.getUserId());
			prestmt.setInt(3,order.getRestaurantId());
			prestmt.setDate(4, sqlDate);
			prestmt.setDouble(5,order.getTotalAmount());
			prestmt.setString(6,order.getStatus());
			prestmt.setString(7, order.getPaymentMethod());
	
			prestmt.executeUpdate();
			
		} 
		catch (SQLException e) {
			System.out.println("Exception in Adding Order");
			e.printStackTrace();
		}
		
	}

	@Override
	public Order getOrder(int orderId) {
		String query="Select * from `order` where `OrderId`=?";
		Order order=null;
		
		try {
			prestmt=con.prepareStatement(query);
			prestmt.setInt(1,orderId);
			res=prestmt.executeQuery();
			if(res.next())
			{
				order=orderDetails(res);
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public void updateOrder(Order order) {
		String query="UPDATE `Order` SET `userId`=?,`restaurantId`=?,`orderDate`=?,`totalAmount`=?,`status`=?,`paymentMethod`=? WHERE `orderId`=? ";
		try {
			prestmt=con.prepareStatement(query);
			java.util.Date utilDate = order.getOrderDate();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			prestmt.setInt(1,order.getUserId());
			prestmt.setInt(2,order.getRestaurantId());
			prestmt.setDate(3,sqlDate);
			prestmt.setDouble(4,order.getTotalAmount());
			prestmt.setString(5,order.getStatus());
			prestmt.setString(6, order.getPaymentMethod());
			prestmt.setInt(7,order.getOrderId());
	
			prestmt.executeUpdate();
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrder(int orderid) {
		String delQuery="delete from `Order` where `orderid`=?";
		try {
			prestmt=con.prepareStatement(delQuery);
			prestmt.setInt(1, orderid);
			
			prestmt.executeUpdate();
			System.out.println("Deleted Successfully!!");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Order> getAllOrderByUser(int userId) {
		List<Order> orders=new ArrayList<Order>();
		String selQuery="Select * from `order`";
		Order order=null;
		try {
			stmt1=con.createStatement();
			res=stmt1.executeQuery(selQuery);
			while(res.next())
			{
				order=orderDetails(res);
				orders.add(order);
				
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return orders;
	}

	private Order orderDetails(ResultSet res2) throws SQLException {
		
			Order order=new Order();
			
			
			order.setOrderId(res2.getInt("orderId"));
			order.setUserId(res2.getInt("userId"));
			order.setRestaurantId(res2.getInt("restaurantId"));
			order.setOrderDate(res2.getDate("orderDate"));
			order.setTotalAmount(res2.getDouble("totalAmount"));
			order.setStatus(res2.getString("status"));
			order.setPaymentMethod(res2.getString("paymentMethod"));
			
			return order;
		
	}

	
	public static int getOrderId() {
		
	        int maxOrderId = 0;
	        
	        try {
	            stmt1 = con.createStatement();
	            // Query to get max orderId from order table
	            String sql = "SELECT MAX(`orderId`) AS maxOrderId FROM `order`";
	            res = stmt1.executeQuery(sql);
	        
	            // Retrieve the result
	            if (res.next()) {
	                maxOrderId = res.getInt("maxOrderId");
	            }
	        }
	            catch(Exception e)
	            {
	            	e.printStackTrace();
	            }
		return maxOrderId+1;
	}

}
