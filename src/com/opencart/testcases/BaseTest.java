package com.opencart.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;

import com.opencart.data.GlobalParametersFile;

public class BaseTest {

	WebDriver driver;
	
	public void Initialise(String browser) {

	
		GlobalParametersFile globalVariables = new GlobalParametersFile();

		globalVariables.readGlobalProperties();
		

		// Checks the browser if it is firefox or not

		if (browser.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();

			// Get the url from the global variables
			driver.get(globalVariables.getUrl());
			// maximise the window
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			// Implicit wait is declared here
			//WebDriverWait driverwait = new WebDriverWait(driver, 5);
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
			
		}
		
		if (browser.equalsIgnoreCase("safari")){
			
		
			  
			  driver = new SafariDriver();
				// Get the url from the global variables
				driver.get(globalVariables.getUrl());
				// maximise the window
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				// Implicit wait is declared here
				//WebDriverWait driverwait = new WebDriverWait(driver, 5);
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				
		 
		  } 
		if (browser.equalsIgnoreCase("chrome")){
			
			
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
			  driver = new ChromeDriver();
				// Get the url from the global variables
				driver.get(globalVariables.getUrl());
				// maximise the window
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				// Implicit wait is declared here
				//WebDriverWait driverwait = new WebDriverWait(driver, 5);
				driver.manage().timeouts().implicitlyWait(240,TimeUnit.SECONDS);
				
		 
		  } 
		}
		

	}


