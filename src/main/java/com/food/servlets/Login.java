package com.food.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.UserInterface;
import com.food.DAOImplementation.copy.UserDAOImp;
import com.food.model.User;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserInterface ui;
	@Override
	public void init() throws ServletException {
		ui=new UserDAOImp();
		super.init();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		User u=ui.getUser(email);
		if(u == null)
		{
			response.sendRedirect("failureLogin.jsp");
		}
		else if(u.getPassword() != null && password.equals(u.getPassword()))
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("user", u);
			
			response.sendRedirect("restaurant");
		}
		else
		{
			request.setAttribute("errorMessage", "Invalid email or password. Please try again.");
            request.getRequestDispatcher("loginPage.jsp").forward(request, response);
		}
	}

}
