package com.food.DAOImplementation.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.MenuInterface;
import com.food.model.Menu;


public class MenuDAOImp implements MenuInterface{
	Connection con=null;
	Statement stmt1=null;
	PreparedStatement prestmt=null;
	ResultSet res=null;
	public MenuDAOImp()
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
	public void addMenu(Menu menu) {
		String query="Insert into `menu`(`menuId`,`restaurantId`,`itemname`,`description`,`price`,`isAvailable`,`imagepath`) "
				+ "values(?,?,?,?,?,?,?)";
		try {
			prestmt=con.prepareStatement(query);
			prestmt.setInt(2,menu.getRestaurantId());
			prestmt.setInt(1,menu.getMenuId());
			prestmt.setString(3,menu.getItemName());
			prestmt.setString(4,menu.getDescription());
			prestmt.setDouble(5,menu.getPrice());
			prestmt.setBoolean(6,menu.isAvailable());
			prestmt.setString(7,menu.getImagePath());
			
			prestmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Menu getMenuByRestaurant(int menuId) {
		String query="Select * from `menu` where `menuId`=?";
		Menu menu=null;
		
		try {
			prestmt=con.prepareStatement(query);
			prestmt.setInt(1,menuId);
			res=prestmt.executeQuery();
			if(res.next())
			{
				menu=menuDetails(res);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menu;
		
	}

	private Menu menuDetails(ResultSet res2) throws SQLException {
		Menu menu=new Menu();
		
		menu.setRestaurantId(res2.getInt("restaurantId"));
		menu.setMenuId(res2.getInt("menuId"));
		
		menu.setItemName(res2.getString("itemName"));
		menu.setDescription(res2.getString("description"));
		
		menu.setPrice(res2.getDouble("price"));
		menu.setAvailable(res2.getBoolean("isAvailable"));
		menu.setImagePath(res2.getString("imagePath"));
		return menu;
	}

	@Override
	public void updateMenu(Menu menu) {
		String qry="update `menu` set `restuarantId`=?,`itemname`=?,`description`=?,`price`=?,`isAvailable`=?,`imagepath`=? where `menuid`=?";
		try {
			prestmt=con.prepareStatement(qry);
			prestmt.setInt(1,menu.getRestaurantId());
			prestmt.setString(2,menu.getItemName());
			
			prestmt.setString(3,menu.getDescription());
			prestmt.setDouble(4, menu.getPrice());
			prestmt.setBoolean(5, menu.isAvailable());
			prestmt.setString(6,menu.getImagePath());
			prestmt.setInt(7,menu.getMenuId());
			prestmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteMenu(int menuId) {
		String delQuery="delete from `menu` where `menuid`=?";
		try {
			prestmt=con.prepareStatement(delQuery);
			prestmt.setInt(1, menuId);
			
			prestmt.executeUpdate();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Menu> getAllMenusByRestaurant(int resId) {
		List<Menu> menuItems=new ArrayList<Menu>();
		String query="Select * from `menu` where restaurantId=?";
		Menu menu=null;
		try {
			prestmt=con.prepareStatement(query);
			prestmt.setInt(1,resId);
			res=prestmt.executeQuery();
			while(res.next())
			{
				menu=menuDetails(res);
				menuItems.add(menu);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuItems;
		
	}
	

}
