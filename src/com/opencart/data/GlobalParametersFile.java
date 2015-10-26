package com.opencart.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.Properties;

public class GlobalParametersFile {
	
	
	private  String url ;
	private String browser;

	private String username;
	private String host;
	private String port ;
	
	
	
	public void createGlobalProperties() {
		// Create a new file

		File file = new File("GlobalParameters.properties");

		// Set the key and pair

		Properties properties = new Properties();

		properties.setProperty("url", "http://localhost:8080/opencart/upload/");
		properties.setProperty("Browser", "FireFox");
		properties.setProperty("username", "root");
		properties.setProperty( "host", "localhost");
		properties.setProperty( "port" , "3307");
		

		// Write the properties to the file

		try {

			FileOutputStream fileoutstream = new FileOutputStream(file);

			properties.store(fileoutstream, "Gloable Parameters");

			fileoutstream.close();

		}

		// Catch the exception and print out the error.

		catch (IOException e) {

			System.out
					.println("Not able to create the file : GlobalParameters.properties");
		}

	}
	
	public String getUrl() {
		return url;
	}


	public String getBrowser() {
		return browser;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}



	public void readGlobalProperties(){
		
		
		File file = new File("GlobalParameters.properties");
		Properties properties;
		FileInputStream fileinputstream ;
		
		try 
		{
			properties = new Properties();
			
	
			fileinputstream	= new FileInputStream(file);
		
			properties.load(fileinputstream);
			
			url = (String) properties.get("url");
			browser = (String) properties.get("Browser");
			
			username = (String) properties.get("username");
			host = (String) properties.get("host");
			port = (String) properties.get("port");
			
			
		
		}
		catch (IOException e){
		
		}
		
		
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GlobalParametersFile [url=" + url + ", browser=" + browser
				+ ", username=" + username + ", host=" + host + ", port="
				+ port + ", getUrl()=" + getUrl() + ", getBrowser()="
				+ getBrowser() + ", getUsername()=" + getUsername()
				+ ", getHost()=" + getHost() + ", getPort()=" + getPort()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
