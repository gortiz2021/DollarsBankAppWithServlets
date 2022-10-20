package com.dollarsbank.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;

import com.dollarsbank.dao.UserDAO;
import com.dollarsbank.model.User;

/**
 * Servlet implementation class RegisterServlet
 */

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDao = new UserDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher("SuccessfulRegister.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		try {		
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/dollarsbank_db";
//			String username = "root";
//			String password = "root";
//			Connection conn = DriverManager.getConnection(url, username, password);
			
			//PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			
			String uname = request.getParameter("username");
			String pword = request.getParameter("password");
			//String confirm = request.getParameter("confirm");
			
			User user = new User();
			user.setUsername(uname);
			user.setPassword(pword);
			
			try {
				userDao.registerUser(user);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("SuccessfulRegister.jsp");
			rd.forward(request, response);
			
		
//			String query = "insert into User (username, password) values (?, ?)";
//			PreparedStatement pstmt = conn.prepareStatement(query);
			
//			pstmt.setString(1, uname);
//			pstmt.setString(2, pword);
			
			//ResultSet rs = pstmt.executeQuery();
//			if(rs.next()) {
//				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
//				out.println("<h1>Account Registered</h1>");
//				rd.forward(request, response);
//			}
//			else {
//				out.println("<h1>Incorrect Login</h1>");
//			}
//			
//		}
//
//		catch (SQLException  e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}

}
