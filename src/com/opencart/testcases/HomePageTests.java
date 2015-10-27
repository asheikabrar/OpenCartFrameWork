package com.opencart.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.opencart.objectrepository.HomePage;

public class HomePageTests extends BaseTest{
	 
	BaseTest basetest = new BaseTest();
	
	
  @Test
  public void verifyNaviagationtoRegistrationPage() {
	  
	  
	  HomePage homepage = new HomePage(basetest.driver);
	  assertEquals(homepage.gotoRegistrationPage(), "Register Account");
	  	  
  }
  
  @Test
    public void verifyNavigationtoLoginPage(){
	  HomePage homepage = new HomePage(basetest.driver);
	  assertEquals(homepage.gotoLoginPage(), "Account Login");
  }
  
  
  @Parameters("browser")
  @BeforeTest
  public void beforeTest(String browser) {
	  

	  basetest.Initialise(browser);
  }

  @AfterTest
  public void afterTest() {
	  
	  basetest.driver.close();
  }

}
