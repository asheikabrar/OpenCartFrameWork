package com.opencart.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class UserRegistrationPageProperties {
	

		private String firstname;
		private String lastname;
		private String email;
		private int telephone;
		private int fax;
		private String company;
		private String address1;
		private String address2;
		private String city;
		private int postcode;
		private String country;
		private String state;
		private String pwd;
		private String confirmpwd;
		private String subscribe;
		private String cont;
		
		
		
		public void createHomePageProperties() {
		// Create a new file

		File file = new File("RegistrationPage.properties");

		// Set the key and pair

		Properties properties = new Properties();

		properties.setProperty("firstname", "input-firstname");
		properties.setProperty("lastname", "input-lastname");
		properties.setProperty("email", "input-email");
		properties.setProperty("telephone", "input-telephone");
		properties.setProperty("fax", "input-fax");
		properties.setProperty("company", "input-company");
		properties.setProperty("address1", "input-address-1");
		properties.setProperty("address2", "input-address-2");
		properties.setProperty("city", "input-city");
		properties.setProperty("postcode", "input-postcode");
		properties.setProperty("country", "input-country");
		properties.setProperty("state", "input-zone");
		properties.setProperty("pwd", "input-password");
		properties.setProperty("confirmpwd", "input-confirm");
		properties.setProperty("cont", "btn btn-primary");

		
		// Write the properties to the file

		try {

			FileOutputStream fileoutstream = new FileOutputStream(file);

			properties.store(fileoutstream, "HomePage Field Values");

			fileoutstream.close();

		}

		// Catch the exception and print out the error.

		catch (IOException e) {

			System.out
					.println("Not able to create the file : RegistrationPage.properties");
		}

	}
	
	public void readHomePageProperties(){
		
		
		File file = new File("RegistrationPage.properties");
		Properties properties;
		FileInputStream fileinputstream ;
		
		try 
		{
			properties = new Properties();
			
	
			fileinputstream	= new FileInputStream(file);
		
			properties.load(fileinputstream);
			
			firstname = (String) properties.get("firstname");
			lastname = (String) properties.get("lastname");
			email = (String) properties.get("email");
			
			telephone = (int) properties.get("telephone");
			fax = (int) properties.get("fax");
			company = (String) properties.get("company");
			
			
			address1 = (String) properties.get("address1");
			address2 = (String) properties.get("address2");
			email = (String) properties.get("email");
			
			city = (String) properties.get("city");
			postcode = (int) properties.get("postcode");
			country = (String) properties.get("country");
			
			state = (String) properties.get("state");
			pwd = (String) properties.get("pwd");
			confirmpwd = (String) properties.get("confirmpwd");
			subscribe = (String) properties.get("subscribe");
			cont = (String) properties.get("cont");
		
			// Catch the exception and print out the error.
			
			
		}
		catch (IOException e){
			
			System.out.println("Not able to read the Homepage.properties file");
		
		}
	}
		

}
