package com.opencart.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class HomePageProperties {


	private  String login ;
	private String account;
	private String registration;
	
	
	public void createHomePageProperties() {
		// Create a new file

		File file = new File("HomePage.properties");

		// Set the key and pair

		Properties properties = new Properties();

		properties.setProperty("account", ".//a[@title='My Account']/span[@class='hidden-xs hidden-sm hidden-md']");
		properties.setProperty("login", ".//a[@href= 'http://localhost:8080/opencart/upload/index.php?route=account/login']");
		properties.setProperty("registration", ".//a[@href='http://localhost:8080/opencart/upload/index.php?route=account/register']");

		
		// Write the properties to the file

		try {

			FileOutputStream fileoutstream = new FileOutputStream(file);

			properties.store(fileoutstream, "HomePage Field Values");

			fileoutstream.close();

		}

		// Catch the exception and print out the error.

		catch (IOException e) {

			System.out
					.println("Not able to create the file : HomePage.properties");
		}

	}
	
	public void readHomePageProperties(){
		
		
		File file = new File("HomePage.properties");
		Properties properties;
		FileInputStream fileinputstream ;
		
		try 
		{
			properties = new Properties();
			
	
			fileinputstream	= new FileInputStream(file);
		
			properties.load(fileinputstream);
			
			login = (String) properties.get("login");
			account = (String) properties.get("account");
			registration = (String) properties.get("registration");
			
			// Catch the exception and print out the error.
			
			
		}
		catch (IOException e){
			
			System.out.println("Not able to read the Homepage.properties file");
		
		}
		
		
		
	}
	
	//method to get the login
	public String getLogin() {
		return login;
	}

	//method to get the account
	public String getAccount() {
		return account;
	}
	//method to get the registration
	public String getRegistration() {
		return registration;
	}


	// We generate toString method for debug purpose
	
	@Override
	public String toString() {
		return "HomePageProperties [login=" + login + ", account=" + account
				+ ", registration=" + registration + ", getLogin()="
				+ getLogin() + ", getAccount()=" + getAccount()
				+ ", getRegistration()=" + getRegistration() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


	
}
