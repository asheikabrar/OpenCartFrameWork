package com.opencart.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


public class UserRegistrationPageData {
	
	
	
	public void connect(String sql){
		
		String username = "root";
		String host = "localhost";
		String port = "3307";
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://" + host +":"+port+ "/opencart",username,"root");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from registration");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
	}

}
