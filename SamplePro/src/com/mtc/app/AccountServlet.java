package com.mtc.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtc.vo.User;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/accountServ")
public class AccountServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h2 align=center>Home Page</h2>");
		
		//User user = (User)request.getAttribute("user");
		
		ServletContext servletContext = request.getServletContext();
		
		User user = (User)servletContext.getAttribute("user");
		
		out.println("<h4>User Details</h4>");
		
		out.println("<p>");
			out.println("Username : "+user.getUsername());
			
		out.println("</p>");
		
		out.println("<p>");
			out.println("Email : "+user.getEmail());		
		out.println("</p>");

		
		out.println("</body></html>");
	}

}

