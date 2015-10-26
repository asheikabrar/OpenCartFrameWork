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

import com.opencart.database.UserRegistrationPageData;
import com.opencart.objectrepository.UserAccountPage;
import com.opencart.objectrepository.UserRegistration;

public class UserRegistrationTests extends BaseTest {

	BaseTest basetest = new BaseTest();


	@Test
	public void verifyUserRegistration() throws SQLException {


			UserRegistration userregistration = new UserRegistration(basetest.driver);
			UserAccountPage useracctpage = new UserAccountPage(basetest.driver);

			ResultSet rs = userregistration.registerUserData();

			int one = 0;
			while (rs.next()) {

				assertEquals("Register Account",userregistration.gotoRegistrationPage());
				userregistration.registerUser();
								
				try {
					File scrFile = ((TakesScreenshot) basetest.driver)
							.getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File(
							"E:\\tmp\\userregistration-" + one + ".png"));

				} catch (IOException e) {
					// TODO Auto-generated catch block

					System.out.println("Not able to take screen shot");
				}
				
				assertTrue(userregistration.isUserRegistered());
				useracctpage.logout();
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

