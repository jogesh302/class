package com.mtc.app;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class ProductSearchServlet
 */
@WebServlet("/searchItems")
public class ItemsSearchServlet extends HttpServlet {
	
	
	
	private ItemsDAO itemDAO;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
				itemDAO= new ItemsDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("itemId"));
		
		Items item=itemDAO.findById(id);
		
		 request.setAttribute("items", item);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("productView.jsp");
		
		requestDispatcher.forward(request, response);
		
		
		
//		PrintWriter out = response.getWriter();
//		
//		out.println("<html><body>");
//		
//		out.println("<h2 align=center>Product Record</h2>");
//		
//		out.println("<table align=center border=2>");
//				
//			out.println("<tr>");
//				out.println("<th>ProductId</th>");
//				out.println("<th>ProductName</th>");
//				out.println("<th>ProductPrice</th>");
//				out.println("<th>ProductDescription</th>");				
//			out.println("</tr>");
//		
//			out.println("<tr>");
//				out.println("<td>"+item.getId()+"</td>");
//				out.println("<td>"+item.getName()+"</td>");
//				out.println("<td>"+item.getPrice()+"</td>");
//				out.println("<td>"+item.getDescribtion()+"</td>");
//			out.println("</tr>");
//		
//		out.println("</table>");
//		
//		out.println("</body></html>");
	}

}
