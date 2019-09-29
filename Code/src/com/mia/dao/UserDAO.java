package com.mia.dao;

public class UserDAO {

	private UserDAO() {
		
	}
	
	private static UserDAO instance = new UserDAO();
	
	public static UserDAO getInstance() {
	
		return instance;
	}
}
