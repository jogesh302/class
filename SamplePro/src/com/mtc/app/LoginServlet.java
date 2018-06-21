package com.mtc.app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtc.dao.UserDAO;
import com.mtc.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginProcess")
public class LoginServlet extends HttpServlet {
	
	private UserDAO userDAO;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		userDAO = new UserDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
			
		User user=userDAO.loadByUsername(username);
		if(user != null) {
			
			if(user.getPassword().equals(password)) {
				
				//request.setAttribute("user",user);
				
				ServletContext servletContext = request.getServletContext();
				
				servletContext.setAttribute("user",user);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("accountServ");
				
				requestDispatcher.forward(request, response);
			}else {
				
				request.setAttribute("pwdmessage","Invalid Password");
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
				
				requestDispatcher.forward(request, response);
			}
			
		}else {
			
			request.setAttribute("usrmessage","Invalid Username");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			
			requestDispatcher.forward(request, response);
		}
	}

}
