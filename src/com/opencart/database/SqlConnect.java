package com.opencart.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opencart.data.GlobalParametersFile;

public class SqlConnect {
	
	GlobalParametersFile globalparam = new GlobalParametersFile();
	
	
public ResultSet connect(String sql){
		
		
		 ResultSet rs = null;
		
		try {
			globalparam.readGlobalProperties();
			Connection conn = DriverManager.getConnection("jdbc:mysql://" + globalparam.getHost() +":"+globalparam.getPort()+ "/userregistration",globalparam.getUsername(),"root");
			Statement statement = conn.createStatement(2, ResultSet.TYPE_FORWARD_ONLY, rs.CONCUR_READ_ONLY);
			statement.setFetchSize(1);
			rs = statement.executeQuery(sql);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(rs);
		return rs;
		
}

}
