package com.food.servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.OrderHistoryInterface;
import com.food.DAOImplementation.copy.OrderHistoryDAOImp;
import com.food.model.OrderHistory;
import com.food.model.User;

/**
 * Servlet implementation class OrderHistoryServlet
 */
@WebServlet("/orderHistory")
public class OrderHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private OrderHistoryInterface oi;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderHistoryServlet() {
        super();
        oi=new OrderHistoryDAOImp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null) {
			List<OrderHistory> orderHistory=oi.getOrderHistoriesByUser(user.getUserId());
			request.setAttribute("orderHistory", orderHistory);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/order_history.jsp");
			dispatcher.include(request, response);
		}
		else
		{
			response.sendRedirect("loginPage.jsp");
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
