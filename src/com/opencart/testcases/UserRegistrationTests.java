package com.opencart.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.objectrepository.UserRegistration;

public class UserRegistrationTests extends BaseTest {

	BaseTest basetest = new BaseTest();

	@Test
	public void verifyUserRegistration() throws SQLException {


			UserRegistration userregistration = new UserRegistration(
					basetest.driver);

			ResultSet rs = userregistration.registerUserData();

			int one = 0;
			while (rs.next()) {

				assertEquals("Register Account",userregistration.gotoRegistrationPage());
				userregistration.registerUser();
				assertTrue(userregistration.isUserRegistered());
				
				try {
					File scrFile = ((TakesScreenshot) basetest.driver)
							.getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File(
							"E:\\tmp\\userregistration-" + one + ".png"));

				} catch (IOException e) {
					// TODO Auto-generated catch block

					System.out.println("Not able to take screen shot");
				}
				one += 1;

			}

	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult)
			throws IOException

	{
		if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println(testResult.getStatus());
			File scrFile = ((TakesScreenshot) basetest.driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils
					.copyFile(scrFile,
							new File("E:\\tmp\\fail\\" + testResult.getName()
									+ ".jpg"));

		}
		if (testResult.getStatus() == ITestResult.SUCCESS) {
			System.out.println(testResult.getStatus());
			File scrFile = ((TakesScreenshot) basetest.driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils
					.copyFile(scrFile,
							new File("E:\\tmp\\pass\\" + testResult.getName()
									+ ".jpg"));

		}
	}

	@BeforeTest
	public void beforeTest() {

		basetest.Initialise();
	}

	@AfterTest
	public void afterTest() {
		basetest.driver.close();
	}

}

/*
 * userregistration.getFirstName().sendKeys(rs.getString("FirstName"));
 * userregistration.getLastName().sendKeys(rs.getString("LastName"));
 * userregistration.getEmail().sendKeys(rs.getString("Email"));
 * userregistration.getTelephone().sendKeys(rs.getString("Telephone"));
 * userregistration.getFax().sendKeys(rs.getString("Fax"));
 * userregistration.getCompany().sendKeys(rs.getString("Company"));
 * userregistration.getAddress1().sendKeys(rs.getString("Address1"));
 * userregistration.getAddress2().sendKeys(rs.getString("Address2"));
 * userregistration.getCity().sendKeys(rs.getString("City"));
 * userregistration.getPostcode().sendKeys(rs.getString("PostCode")); Select
 * countrydropdown = new Select(userregistration.getCountry());
 * 
 * // dropdownbox
 * 
 * countrydropdown.selectByVisibleText(rs.getString("Country"));
 * 
 * // dropdownbox Select regiondropdown = new
 * Select(userregistration.getZone());
 * regiondropdown.selectByVisibleText(rs.getString("Region"));
 * 
 * userregistration.getPassword().sendKeys(rs.getString("Pword"));
 * userregistration.getConfirm() .sendKeys(rs.getString("Pwordconfirm"));
 * 
 * userregistration.getSubscribeoptions().click();
 * 
 * userregistration.getAgree().click();
 */
// Now you can do whatever you need to do with it, for example copy
// somewhere
