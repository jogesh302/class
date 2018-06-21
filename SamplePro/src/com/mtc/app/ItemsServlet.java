package com.mtc.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtc.dao.ItemsDAO;
import com.mtc.vo.Items;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/allproducts")
public class ItemsServlet extends HttpServlet {
	
	private ItemsDAO itemsDAO;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		itemsDAO = new ItemsDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Items> items = itemsDAO.findAll();
		
		request.setAttribute("itemsList", items);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("items.jsp");
		
		requestDispatcher.forward(request, response);
		
		
		
	}

}
