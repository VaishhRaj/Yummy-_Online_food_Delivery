package com.food.servlets;

import java.io.IOException;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.OrderInterface;
import com.food.DAOImplementation.copy.OrderDAOImp;
import com.food.DAOImplementation.copy.OrderHistoryDAOImp;
import com.food.DAOImplementation.copy.OrderItemDAOImp;
import com.food.model.Cart;
import com.food.model.CartItem;
import com.food.model.User;
import com.food.model.Order;
import com.food.model.OrderHistory;
import com.food.model.OrderItem;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrderInterface order;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    public Checkout() {
    	order=new OrderDAOImp();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int menuId=Integer.parseInt(request.getParameter("menuId"));
		
		OrderItemDAOImp orderItem=new OrderItemDAOImp();
		
		HttpSession session=request.getSession();
		
		Cart cart=(Cart) session.getAttribute("cart");
		User user=(User)session.getAttribute("user");
		if(cart != null  && !cart.getItems().isEmpty())
		{
			if(user!=null) {
			String paymentMethod=request.getParameter("paymentMethod");
		
			Order orderInfo=new Order();
			OrderItem items=new OrderItem();
			
			
			//Add Cart items to the order and Calculate the total Amount
			double totalAmount=(double) session.getAttribute("total");;
			
			orderInfo.setOrderId(OrderDAOImp.getOrderId());
			orderInfo.setUserId(user.getUserId());
			orderInfo.setRestaurantId((int)session.getAttribute("restaurantId"));
			orderInfo.setOrderDate(new Date());
			
			orderInfo.setStatus("Pending");
			orderInfo.setTotalAmount(totalAmount);
			orderInfo.setPaymentMethod(paymentMethod);
			//Adding order Info of Order
			
			order.addOrder(orderInfo);
			
			for(CartItem item: cart.getItems().values())
			{
				double total=0;
				total += item.getPrice() * item.getQuantity();
				//Setting Attributes of ordered Item
				items.setOrderId(orderInfo.getOrderId());
				items.setMenuId(menuId);
				items.setItemName(item.getName());
				items.setQuantity(item.getQuantity());
				items.setItemTotal(total);
				//Adding ordered Item Info
				orderItem.addOrderItem(items);
				addOrderHistory(user.getUserId(),items);
				
			}
			
			
			
			session.removeAttribute("cart");
			session.setAttribute("orderItem", items);
			session.setAttribute("totalAmount", totalAmount);
			response.sendRedirect("OrderPage.jsp");
			}
			else
			{
				response.sendRedirect("loginPage.jsp");
			}
		}
		else
			response.sendRedirect("cart.jsp");
	
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

}
	private void addOrderHistory(int userId,OrderItem order2) {
		// TODO Auto-generated method stub
		OrderHistoryDAOImp orderHistory=new OrderHistoryDAOImp();
		OrderHistory oh=new OrderHistory();
		oh.setUserId(userId);
		oh.setOrderId(order2.getOrderId());
		oh.setItemName(order2.getItemName());
		oh.setQuantity(order2.getQuantity());
		oh.setOrderDate(new Date());
		oh.setTotalAmount(order2.getItemTotal());
		oh.setStatus("Delivered");
		
		orderHistory.addOrderHistory(oh);
	
		
	}
}
