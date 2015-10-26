package com.opencart.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencart.data.GlobalParametersFile;

public class BaseTest {

	WebDriver driver;
	public void Initialise() {

	
		GlobalParametersFile globalVariables = new GlobalParametersFile();

		globalVariables.readGlobalProperties();

		// Checks the browser if it is firefox or not

		if (globalVariables.getBrowser().equals("FireFox")) {

			driver = new FirefoxDriver();

			// Get the url from the global variables

			driver.get(globalVariables.getUrl());

			// maximise the window
			driver.manage().window().maximize();

			driver.manage().deleteAllCookies();

			// Implicit wait is declared here
			//WebDriverWait driverwait = new WebDriverWait(driver, 5);
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			System.out.println(driver.getTitle());

			
		}

	}

}
