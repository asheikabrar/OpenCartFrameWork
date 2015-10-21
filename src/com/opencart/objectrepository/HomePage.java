package com.opencart.objectrepository;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.data.HomePageProperties;

public class HomePage {
	
	
	//Declare web driver
	private   WebDriver driver;
	HomePageProperties homepageproperties = new HomePageProperties();
	
	
	// find the element using the page factory annotation
	@FindBy(xpath = ".//a[@title='My Account']/span[@class='hidden-xs hidden-sm hidden-md']")
	private WebElement account;
	
	
	//Home page  constructor 
	public HomePage(WebDriver driver) {
		
		// create and read the properties 
		homepageproperties.createHomePageProperties();
		homepageproperties.readHomePageProperties();
		
		this.driver = driver;
		
		//initialise the pagefactory elements 
		PageFactory.initElements(driver, this);
		
	}

	//Method to find the login element
	public WebElement login(){
		
		account.click();
		return driver.findElement(By.xpath(homepageproperties.getLogin()));
	}

	//method to find the register element
	public WebElement register(){
		
		account.click();
		return driver.findElement(By.xpath(homepageproperties.getRegistration()));
	}

	// method to navigate to the registration page and get the title of the page
	public String  gotoRegistrationPage(){
		
		register().click();
		
		return	driver.getTitle();
		
	}
	
	//method to navigate to the login page and get the title of the page
	public String gotoLoginPage(){
		
		login().click();
		
		return driver.getTitle();
	}


}
