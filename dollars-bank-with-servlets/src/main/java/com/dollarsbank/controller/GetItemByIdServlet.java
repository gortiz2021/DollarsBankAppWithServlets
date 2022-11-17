package com.dollarsbank.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dollarsbank.model.Items;
import com.dollarsbank.dao.ItemsDAO;

/**
 * Servlet implementation class GetItemByIdServlet
 */
public class GetItemByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
//		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//doGet(request, response);
		
		List<Items> itemsArr = new ArrayList<>();
		//ItemsDAO itemsDao = new ItemsDAO();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/dollarsbank_servlets";
			String username = "root";
			String password = "root";
			Connection conn = DriverManager.getConnection(url, username, password);
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			String itemCode = request.getParameter("item-name");
			
			String query = "select * from items where item_code = ?;";
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, itemCode);
			
			System.out.println(pstmt);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
//				request.getSession();
				
				Items items = new Items();
				items.setItem_id(rs.getInt("item_id"));
				items.setItem_name(rs.getString("item_name"));
				items.setItem_code(rs.getString("item_code"));
				items.setItem_price(rs.getDouble("item_price"));
				itemsArr.add(items);
				
				
				request.setAttribute("itemsArr", itemsArr);	
//				request.getRequestDispatcher(request.getAttribute("jspName").toString()).forward(request, response);
				
		
				RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
				rd.include(request, response);
				
//				out.println("<p>" + itemsArr.toString() + "<p>");
				out.println("<div>"	
							+ "<h1>List</h1>"
						       + "<table>"
						           + "<tr>"
						               + "<th>Name</th>"
						               + "<th>Code</th>"
						               + "<th>Price</th>"
						            + "</tr>"
						            + "<tr>"
						            	+ "<th>" + itemsArr.toString() + "</th>"
						            	+ "<th>" + itemsArr.toString() + "</th>"
						            	+ "<th>" + items.toString() + "</th>"
						            + "</tr>"
						       + "</table>"
							+ "</div>"
						   );
			}
			else {
				out.println("<h1>Item Does Not Exist!</h1>");
			}
			
			conn.close();
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();			
		}
		catch (SQLException  e) {
			e.printStackTrace();
		} 
	}
}
