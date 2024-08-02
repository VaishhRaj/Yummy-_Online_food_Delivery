package com.food.DAOImplementation.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.OrderItemInterface;
import com.food.model.Menu;
import com.food.model.OrderItem;

public class OrderItemDAOImp implements OrderItemInterface{

	Connection con=null;
	Statement stmt1=null;
	PreparedStatement prestmt=null;
	ResultSet res=null;
	public OrderItemDAOImp()
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
	public void addOrderItem(OrderItem orderitem) {
		String query="Insert into `OrderItem`(`orderId`,`menuId`,`itemName`,`quantity`,`itemTotal`) "
				+ "values(?,?,?,?,?)";
		try {
			prestmt=con.prepareStatement(query);
			//prestmt.setInt(1,orderitem.getOrderItemId());
			prestmt.setInt(1,orderitem.getOrderId());
			prestmt.setInt(2,orderitem.getMenuId());
			prestmt.setString(3,orderitem.getItemName());
			prestmt.setInt(4,orderitem.getQuantity());
			prestmt.setDouble(5,orderitem.getItemTotal());
	
			prestmt.executeUpdate();
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public OrderItem getOrderItem(int itemId) {
		String query="Select * from `orderItem` where `OrderItemId`=?";
		OrderItem order=null;
		
		try {
			prestmt=con.prepareStatement(query);
			prestmt.setInt(1,itemId);
			res=prestmt.executeQuery();
			if(res.next())
			{
				order=orderItemDetails(res);
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return order;
		
	}

	private OrderItem orderItemDetails(ResultSet res2) throws SQLException {
		OrderItem order=new OrderItem();
		
		order.setOrderItemId(res2.getInt("orderItemId"));
		order.setOrderId(res2.getInt("orderId"));
		order.setMenuId(res2.getInt("menuId"));
		order.setItemName(res2.getString("itemName"));
		order.setQuantity(res2.getInt("quantity"));
		order.setItemTotal(res2.getDouble("itemTotal"));
		
		return order;
		
	}
	@Override
	public void updateOrderItem(OrderItem orderitem) {
		String query="UPDATE `OrderItem` SET `orderId`=?,`menuId`=?,`itemName`=?,`quantity`=?,`itemTotal`=? Where `OrderItemId`=?";
		try {
			prestmt=con.prepareStatement(query);
			
			prestmt.setInt(1,orderitem.getOrderId());
			prestmt.setInt(2,orderitem.getMenuId());
			prestmt.setString(3,orderitem.getItemName());
			prestmt.setInt(4,orderitem.getQuantity());
			prestmt.setDouble(5,orderitem.getItemTotal());
			prestmt.setInt(6,orderitem.getOrderItemId());
	
			prestmt.executeUpdate();
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteOrderItem(int itemId) {
		String delQuery="delete from `OrderItem` where `orderItemid`=?";
		try {
			prestmt=con.prepareStatement(delQuery);
			prestmt.setInt(1, itemId);
			
			prestmt.executeUpdate();
			System.out.println("Deleted Successfully!!");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public List<OrderItem> getOrderItemsByOrder(int orderId) {
		List<OrderItem> items=new ArrayList();
		String selQuery="Select * from `orderitem` where orderId=?";
		OrderItem item=null;
		try {
			prestmt=con.prepareStatement(selQuery);
			prestmt.setInt(1, orderId);
			while(res.next())
			{
				item=orderItemDetails(res);
				items.add(item);
				
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return items;
		
	}

}
