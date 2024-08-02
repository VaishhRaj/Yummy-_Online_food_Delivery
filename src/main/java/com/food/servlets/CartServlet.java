package com.food.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.model.Cart;
import com.food.model.CartItem;
import com.food.model.Menu;
import com.food.DAO.MenuInterface;
import com.food.DAOImplementation.copy.MenuDAOImp;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/*@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cart Servlet Called!");
		HttpSession session = request.getSession();
		Cart cart=(Cart) session.getAttribute("cart");
		if(cart==null)
		{
			cart=new Cart();
			session.setAttribute("cart", cart);
		}
		String action=request.getParameter("action");
		System.out.println(action);
		if("add".equals(action)) {
			addItemToCart(request,cart);
			
		}else if("update".equals(action)) {
			updateCartItem(request,cart);
			
		}else if("remove".equals(action))
		{
			removeItemFromCart(request,cart);
		}
		session.setAttribute("cart",cart);
		response.sendRedirect("cart.jsp");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String itemName=request.getParameter("itemName");
		session.setAttribute("itemName",itemName);
		Cart cart=(Cart) session.getAttribute("cart");
		double total=0.0;
		if(cart==null)
		{
			cart=new Cart();
			session.setAttribute("cart", cart);
		}
		String action=request.getParameter("action");
		
		if("add".equals(action)) {
			addItemToCart(request,cart);
			
		}else if("update".equals(action)) {
			updateCartItem(request,cart);
			
		}else if("remove".equals(action))
		{
			removeItemFromCart(request,cart);
		}
		for(CartItem item: cart.getItems().values())
		{
			total += item.getPrice() * item.getQuantity();
		}
		session.setAttribute("cart",cart);
		session.setAttribute("total",total);
		response.sendRedirect("cart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

	

	private double addItemToCart(HttpServletRequest request, Cart cart)
	{
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		MenuInterface menu=new MenuDAOImp();
		Menu menuItem=menu.getMenuByRestaurant(itemId);
		HttpSession session=request.getSession();
		session.setAttribute("restaurantId", menuItem.getRestaurantId());
		session.setAttribute("menuId", itemId);
		
		if(menuItem!=null)
		{
			CartItem item=new CartItem(menuItem.getMenuId(),menuItem.getRestaurantId(),menuItem.getItemName(),quantity,menuItem.getPrice());
			return cart.addItem(item);
		}
		return 0.0;
	}
	
	private double updateCartItem(HttpServletRequest request, Cart cart) {
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		return cart.updateItem(itemId, quantity);
		
	}
	private void removeItemFromCart(HttpServletRequest request, Cart cart) {
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		cart.removeItem(itemId);
		
	}

}
