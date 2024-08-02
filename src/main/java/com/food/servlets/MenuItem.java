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

import com.food.DAO.MenuInterface;
import com.food.DAOImplementation.copy.MenuDAOImp;
import com.food.model.Menu;

/**
 * Servlet implementation class MenuItem
 */
@WebServlet("/menu")
public class MenuItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
     MenuInterface mi;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuItem() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void init() throws ServletException {
		mi=new MenuDAOImp();
		super.init();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int resId=Integer.parseInt(req.getParameter("restaurantId"));
		List<Menu> itemList=mi.getAllMenusByRestaurant(resId);
		//HttpSession session=req.getSession(true);
		
		
		req.setAttribute("itemList", itemList);
		RequestDispatcher reqDis= req.getRequestDispatcher("menu.jsp");
		reqDis.forward(req, res);
		//super.service(arg0, arg1);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
