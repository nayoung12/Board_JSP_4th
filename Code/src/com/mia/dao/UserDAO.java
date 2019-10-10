package com.mia.dao;

public class UserDAO {

	public UserDAO() {
		
	}
	
	public static UserDAO instance = new UserDAO();
	
	public static UserDAO getInstance() {
	
		return instance;
	}
}
