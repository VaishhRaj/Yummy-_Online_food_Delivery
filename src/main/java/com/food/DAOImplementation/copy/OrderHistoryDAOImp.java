package com.food.DAOImplementation.copy;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.OrderHistoryInterface;
import com.food.model.OrderHistory;

public class OrderHistoryDAOImp implements OrderHistoryInterface{

	Connection con=null;
	Statement stmt1=null;
	PreparedStatement prestmt=null;
	ResultSet res=null;
	public OrderHistoryDAOImp()
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
	public void addOrderHistory(OrderHistory order) {
		String query="Insert into `OrderHistory`(`userId`,`orderId`,`itemName`,`quantity`,`orderDate`,`totalAmount`,`status`) "
				+ "values(?,?,?,?,?,?,?)";
		try {
			prestmt=con.prepareStatement(query);
			java.util.Date utilDate = order.getOrderDate();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			prestmt.setInt(2,order.getOrderId());
			prestmt.setInt(1,order.getUserId());
			prestmt.setString(3,order.getItemName());
			prestmt.setInt(4,order.getQuantity());
			prestmt.setDate(5, sqlDate);
			prestmt.setDouble(6,order.getTotalAmount());
			
			prestmt.setString(7,order.getStatus());
	
			prestmt.executeUpdate();
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public OrderHistory getOrderHistory(int orderHisId) {
		String query="Select * from `orderHistory` where `OrderHistoryId`=?";
		OrderHistory order=null;
		
		try {
			prestmt=con.prepareStatement(query);
			prestmt.setInt(1,orderHisId);
			res=prestmt.executeQuery();
			if(res.next())
			{
				order=orderHistoryDetails(res);
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return order;
		
	}

	private OrderHistory orderHistoryDetails(ResultSet res2) throws SQLException {
		OrderHistory order=new OrderHistory();
		
		order.setOrderHistoryId(res2.getInt("orderHistoryId"));
		order.setUserId(res2.getInt("userId"));
		order.setOrderId(res2.getInt("orderId"));
		order.setItemName(res2.getString("itemName"));
		order.setQuantity(res2.getInt("quantity"));
		order.setOrderDate(res2.getDate("orderDate"));
		order.setTotalAmount(res2.getDouble("totalAmount"));
		order.setStatus(res2.getString("status"));
		
		return order;
		
	}
	@Override
	public void updateOrderHistory(OrderHistory order) {
		String query="update `OrderHistory` set `userId`=?,`orderId`=?,`orderDate`=?,`totalAmount`=?,`status`=? where `OrderHistoryId`=?";
		try {
			prestmt=con.prepareStatement(query);
			java.util.Date utilDate = order.getOrderDate();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			prestmt.setInt(1,order.getUserId());
			prestmt.setInt(2,order.getOrderId());
			prestmt.setString(3,order.getItemName());
			prestmt.setInt(4,order.getQuantity());
			prestmt.setDate(5, sqlDate);
			prestmt.setDouble(6,order.getTotalAmount());
			prestmt.setString(7,order.getStatus());
			
	
			prestmt.executeUpdate();
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrderHistory(int orderHisId) {
		String delQuery="delete from `OrderHistory` where `orderHistoryid`=?";
		try {
			prestmt=con.prepareStatement(delQuery);
			prestmt.setInt(1, orderHisId);
			
			prestmt.executeUpdate();
			System.out.println("Deleted Successfully!!");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public List<OrderHistory> getOrderHistoriesByUser(int userId) {
		List<OrderHistory> historyList=new ArrayList<OrderHistory>();
		String selQuery="Select * from `orderhistory` where `userId`=? order by `orderId` desc";
		OrderHistory history=null;
		try {
			prestmt=con.prepareStatement(selQuery);
			prestmt.setInt(1, userId);
			
			res=prestmt.executeQuery();
			while(res.next())
			{
				history=orderHistoryDetails(res);
				historyList.add(history);
				
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return historyList;
	}

}
