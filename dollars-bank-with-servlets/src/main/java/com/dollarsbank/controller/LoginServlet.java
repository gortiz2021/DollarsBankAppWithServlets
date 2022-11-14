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

//import com.dollarsbank.connection.ConnectionManager;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {		
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/dollarsbank_servlets";
			String username = "root";
			String password = "root";
			Connection conn = DriverManager.getConnection(url, username, password);
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			
			String uname = request.getParameter("username");
			String pword = request.getParameter("password");
		
			String query = "select username from User where username=? and password=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, uname);
			pstmt.setString(2, pword);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				request.getSession().setAttribute("currentUser", username);
				RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
				rd.forward(request, response);
			}
			else {
				out.println("<h1>Incorrect Login</h1>");
			}
			conn.close();
			
		}

		catch (SQLException  e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
