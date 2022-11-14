package com.dollarsbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dollarsbank.model.Items;

public class ItemsDAO {

	public List<Items> getAllItems() throws ClassNotFoundException {
		
		ResultSet rs;
		
		List<Items> itemsArr = new ArrayList<>();
		
		String query = "select * from items;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/dollarsbank_servlets";
			String username = "root";
			String password = "root";
			Connection conn = DriverManager.getConnection(url, username, password);
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Items items = new Items();
				items.setItem_id(rs.getInt("item_id"));
				items.setItem_name(rs.getString("item_name"));
				items.setItem_code(rs.getString("item_code"));
				items.setItem_price(rs.getDouble("item_price"));
				itemsArr.add(items);
			}
			
			conn.close();
		}
		catch (SQLException  e) {
			e.printStackTrace();
		} 
		
		return itemsArr;
	}
	
}
