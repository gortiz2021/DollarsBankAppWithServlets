package com.dollarsbank.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        RequestDispatcher rd = request.getRequestDispatcher("./");
		rd.forward(request, response);
		
		System.out.println("Session before invalidate: "+ request.getSession(false));
		
		// For understanding purpose, print the session object in the console before
        // invalidating the session.
		request.getSession().invalidate();
		
		// Print the session object in the console after invalidating the session.
        System.out.println("Session after invalidate: "+ request.getSession(false));
		
		out.println("Successfully Logged out.");
	}

}
