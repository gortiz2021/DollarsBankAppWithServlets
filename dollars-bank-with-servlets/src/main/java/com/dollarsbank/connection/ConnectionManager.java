package com.dollarsbank.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	// Variables
	// Connection String is:
	// Interface + sql Enginge + sql server ip address (localhost is an alias) + port number + db name
	private static final String URL = "jdbc:mysql://localhost:3306/dollarsbank_servlets";
	// for mac, add: ?serverTimezone=EST5EDT
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connected to " + URL);
			
		} catch(SQLException e) {
			System.out.println("Could not connect, see message: " + e.getMessage());
		}
		
		return conn;
		
	}

//	public static void main(String[] args) {
//		
//		Connection conn = ConnectionManager.getConnection();
//		
//		try {
//			conn.close();
//			System.out.println("Connection closed.");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

}

