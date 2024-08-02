package com.food.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO.UserInterface;
import com.food.DAOImplementation.copy.UserDAOImp;
import com.food.model.User;

@WebServlet("/register")
public class RegisterUser extends HttpServlet {
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
    public RegisterUser() {
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
		String username,email,password,confirmPassword,address,role;
		username=request.getParameter("username");
		
		password=request.getParameter("password");
		confirmPassword=request.getParameter("confirm-password");
		email=request.getParameter("email");
		address=request.getParameter("address");
		role=request.getParameter("role");
		PrintWriter out=response.getWriter();
		if(password.length()<8)
		{
			request.setAttribute("errorMessage", "Password must be minimum of 8 Characters");
            request.getRequestDispatcher("createAccount.jsp").forward(request, response);
		}
		else if(password.equals(confirmPassword))
		{
			User u=new User(username,password,email,address,role);
			int x=ui.addUser(u);
			if(x != 0)
			{
				response.sendRedirect("loginPage.jsp");
			}
			else
			{
				if(ui.getUser(email) != null)
				{
					request.setAttribute("errorMessage", "Email already exists");
		            request.getRequestDispatcher("createAccount.jsp").forward(request, response);
				}
				else
					request.setAttribute("errorMessage", "Error:(");
	            request.getRequestDispatcher("createAccount.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("errorMessage", "Password and Confirm Password Does not Match!!");
            request.getRequestDispatcher("createAccount.jsp").forward(request, response);
		}
		
	}


	
}
