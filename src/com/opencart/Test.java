package com.opencart;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.opencart.database.UserRegistrationPageData;


public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		
		UserRegistrationPageData udata = new UserRegistrationPageData();
		
		
		ResultSet rs= udata.customer("select * from oc_customer where email = 'h@h.com'");
		
		while (rs.next())
		{
			String a = rs.getString("email");
			System.out.println(a);
		}
		
		/*
			SqlConnect sqc = new SqlConnect();
		
			sqc.connect("select * from registration");*/
		
/*			GlobalParametersFile gp = new GlobalParametersFile();
			
			gp.createGlobalProperties();
			HomePageProperties hp = new HomePageProperties();
			
		
			BaseTest bt = new BaseTest();
			
			bt.Initialise();*/
	}

}
