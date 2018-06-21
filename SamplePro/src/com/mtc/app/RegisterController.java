package com.mtc.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/registerProcess")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("**********RegisterController : doGet()*********** ");
		
		String fristname = request.getParameter("fristname");
		String lastname = request.getParameter("lastname");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h2 align=center>U R Registered Successfully<h2/>");
		out.println("<p>");
		out.println("FristName:"+fristname);
		out.println("<p>");
		out.println("LastName:"+lastname);
		out.println("<p>");
		out.println("City:"+city);
		out.println("<p>");
		out.println("State:"+state);
		out.println("<p>");
		
		
		
		
	}

}
