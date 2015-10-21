package com.opencart.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class GlobalParametersFile {
	
	
	private  String url ;
	private String browser;
	
	
	public void createGlobalProperties() {
		// Create a new file

		File file = new File("GlobalParameters.properties");

		// Set the key and pair

		Properties properties = new Properties();

		properties.setProperty("url", "http://localhost:8080/opencart/upload/");
		properties.setProperty("Browser", "FireFox");

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

	@Override
	public String toString() {
		
		return "GlobalParametersFile [url=" + url + ", browser=" + browser
				+ "]";
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
			
		
		}
		catch (IOException e){
		
		}
		
		
		
	}
	
	

}
