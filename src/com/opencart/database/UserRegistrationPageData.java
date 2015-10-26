package com.opencart.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


public class UserRegistrationPageData {
	
	
	
	public ResultSet customer(String sql){
		
		String username = "root";
		String host = "localhost";
		String port = "3306";
		ResultSet rs = null;
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://" + host +":"+port+ "/opencart",username,"");
			Statement statement = conn.createStatement();
			
		     rs = statement.executeQuery(sql);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	
		
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserRegistrationPageData [getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
