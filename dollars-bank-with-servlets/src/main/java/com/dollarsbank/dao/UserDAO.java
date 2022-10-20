package com.dollarsbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dollarsbank.model.User;

public class UserDAO {

	public int registerUser(User user) throws ClassNotFoundException {
		
		String query = "insert into User (username, password) values (?, ?)";
		
		int result = 0;
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/dollarsbank_db";
			String username = "root";
			String password = "root";
			Connection conn = DriverManager.getConnection(url, username, password);
			
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			
			System.out.println(pstmt);
			result = pstmt.executeUpdate();
			
			conn.close();

		}
		catch (SQLException  e) {
			e.printStackTrace();
		} 
		
		return result;
		
	}
	
	
}
