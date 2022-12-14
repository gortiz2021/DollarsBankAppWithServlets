package com.dollarsbank.model;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Variables come from the columns in the table named "user"
	// The table is in the "progress_checker" database
	private int id;
	private String username;
	private String password;
	
	// Two default constructors that are to create new objects of this class
	public User() {
		this(-1, "N/A", "N/A");
	}
	
	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;		
	}
	
	// A list of auto-generated getter and setter functions for every variable 
	public long getUser_id() {
		return id;
	}
	
	public void setUser_id(int user_id) {
		this.id = user_id;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
	// Overriden toString() method to display any object of this class
	@Override
	public String toString() {
		return "User [user_id=" + id + ", username=" + username + ", password=" + password + "]";
	}
}