package com.opencart.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountPage {

	private WebDriver driver;

	WebElement logoutbtn;

	@FindAll({ @FindBy(xpath = ".//div[@class='list-group']/a") })
	private List<WebElement> logout;

	/**
	 * @return the logout
	 */
	public List<WebElement> getLogout() {
		return logout;
	}

	/**
	 * @return the logoutbtn
	 */
	public WebElement getLogoutbtn() {
		
		for (int i = 0; i < logout.size(); i++) {
			logoutbtn = logout.get(i);
			String linktxt = logoutbtn.getText();
			if(linktxt.equals("Logout")){
				break;
			}
					
		}
		return logoutbtn;

	}
	
	public UserAccountPage(WebDriver driver) {
	
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	public void logout()
	{
		getLogoutbtn().click();
		
	}
}
