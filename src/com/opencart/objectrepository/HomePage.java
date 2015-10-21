package com.opencart.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private   WebDriver driver;
	
	
	@FindBy(xpath =".//a[@title='My Account']/span[@class='hidden-xs hidden-sm hidden-md']")
	private WebElement account;
	
	public HomePage(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	public WebElement login(){
		
		
		return driver.findElement(By.className("hello"));
	}

	public WebElement register(){
		

		account.click();
		return driver.findElement(By.xpath(".//a[@href='http://localhost:8080/opencart/upload/index.php?route=account/register']"));
	}


	public String  gotoRegistrationPage(){
		
		register().click();
		
		return	driver.getTitle();
		
	}
	
	public void gotoLoginPage(){
		
	}


}
