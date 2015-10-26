package com.opencart.objectrepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.opencart.data.UserRegistrationPageProperties;
import com.opencart.database.SqlConnect;

public class UserRegistration {

	// Declare web driver
	private WebDriver driver;
	
	UserRegistrationPageProperties registrationProperties = new UserRegistrationPageProperties();
		
	ResultSet rs;
	public UserRegistration(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-firstname")
	private WebElement firstName;

	@FindBy(id = "input-lastname")
	private WebElement lastName;

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-telephone")
	private WebElement telephone;

	@FindBy(id = "input-fax")
	private WebElement fax;

	@FindBy(id = "input-company")
	private WebElement company;

	@FindBy(id = "input-address-1")
	private WebElement address1;

	@FindBy(id = "input-address-2")
	private WebElement address2;

	@FindBy(id = "input-city")
	private WebElement city;

	@FindBy(id = "input-postcode")
	private WebElement postcode;

	@FindBy(id = "input-country")
	private WebElement country;

	@FindBy(id = "input-zone")
	private WebElement zone;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(id = "input-confirm")
	private WebElement confirm;

	
	//List<WebElement> optionbtn = driver.findElements(By.xpath(".//*[@type='radio']"));
	
	@FindAll({ @FindBy(xpath = ".//*[@type='radio' ][@name='newsletter']") })
	private List<WebElement> subscribeoption;

	@FindBy(xpath = ".//*[@class='btn btn-primary'][@type='submit']")
	private WebElement btnContinue;

	@FindBy(xpath = ".//*[@type='checkbox']")
	private WebElement agree;
	
	@FindBy(xpath=".//div[@class='alert alert-danger']")
	private WebElement alert;

	/**
	 * @return the firstName
	 */
	public WebElement getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public WebElement getLastName() {
		return lastName;
	}

	/**
	 * @return the email
	 */
	public WebElement getEmail() {
		return email;
	}

	/**
	 * @return the telephone
	 */
	public WebElement getTelephone() {
		return telephone;
	}

	/**
	 * @return the fax
	 */
	public WebElement getFax() {
		return fax;
	}

	/**
	 * @return the company
	 */
	public WebElement getCompany() {
		return company;
	}

	/**
	 * @return the address1
	 */
	public WebElement getAddress1() {
		return address1;
	}

	/**
	 * @return the address2
	 */
	public WebElement getAddress2() {
		return address2;
	}

	/**
	 * @return the city
	 */
	public WebElement getCity() {
		return city;
	}

	/**
	 * @return the postcode
	 */
	public WebElement getPostcode() {
		return postcode;
	}

	/**
	 * @return the country
	 */
	public WebElement getCountry() {
		return country;
	}

	/**
	 * @return the zone
	 */
	public WebElement getZone() {
		return zone;
	}

	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return password;
	}

	/**
	 * @return the confirm
	 */
	public WebElement getConfirm() {
		return confirm;
	}

	WebElement subscribeoptions ;	/**
	 * @return the subscribeoption
	 * @throws SQLException 
	 */
	public WebElement getSubscribeoptions() throws SQLException {
			

		for (int i=0 ;i < subscribeoption.size();i++){
			
			
			 subscribeoptions = subscribeoption.get(i);
			String optionSubscribe = subscribeoptions.getAttribute("Value");
			
			System.out.println(optionSubscribe);
			if (optionSubscribe.equals("0") && rs.getString("subscribe").equals("0"))
			{
			 
				
			 break;
			}
			if (optionSubscribe.equals("1") && rs.getString("subscribe").equals("1"))
			{
				
				break;
				
			}
			
			
		}
		return subscribeoptions;
	
		
		
	}

	/**
	 * @return the btnContinue
	 */
	public WebElement getBtnContinue() {
		return btnContinue;
	}

	/**
	 * @return the agree
	 */
	public WebElement getAgree() {
		return agree;
	}

	public ResultSet registerUserData() {
		String sql = "select * from registration";
		SqlConnect sqlconn = new SqlConnect();
		rs = sqlconn.connect(sql);
		return rs;
				
	}
	
	public String gotoRegistrationPage(){
		
		
		  HomePage homepage = new HomePage(driver);
		  return homepage.gotoRegistrationPage();
		
		
	}
	
	public void registerUser() throws SQLException
	{
		getFirstName().sendKeys(rs.getString("FirstName"));
		getLastName().sendKeys(rs.getString("LastName"));
		getEmail().sendKeys(rs.getString("Email"));
		getTelephone().sendKeys(rs.getString("Telephone"));
		getFax().sendKeys(rs.getString("Fax"));
		getCompany().sendKeys(rs.getString("Company"));
		getAddress1().sendKeys(rs.getString("Address1"));
		getAddress2().sendKeys(rs.getString("Address2"));
		getCity().sendKeys(rs.getString("City"));
		getPostcode().sendKeys(rs.getString("PostCode"));
		Select countrydropdown = new Select(getCountry());
		// dropdownbox
		countrydropdown.selectByVisibleText(rs.getString("Country"));
		// dropdownbox
		Select regiondropdown = new Select(getZone());
		regiondropdown.selectByVisibleText(rs.getString("Region"));
		getPassword().sendKeys(rs.getString("Pword"));
		getConfirm().sendKeys(rs.getString("Pwordconfirm"));
		getSubscribeoptions().click();
		getAgree().click();
		getBtnContinue().click();
		
	}
	
	public boolean isUserRegistered() throws SQLException{
		
		boolean title = false;
		String expected = "Your Account Has Been Created!";
		String actual = driver.getTitle();
		
		if (expected.equals(actual)){
			
			title = true ;
			System.out.println("user"+rs.getString("FirstName").concat(rs.getString("LastName")+" is registered"));
		}
		else 
		{
			title = false;
			System.out.println("User is not Registered the error :"+ alert.getText());
		}
		return title;
	}


}
