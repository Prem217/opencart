package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends Basepage {

	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	
	}
	
	@FindBy(css="#input-firstname")
	WebElement Firstname;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement Lastname;
	
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement Email;

	@FindBy(xpath="//input[@id='input-telephone']") 
	WebElement Telephone;

	@FindBy(xpath="//input[@id='input-password']") 
	WebElement Password;

	@FindBy(xpath="//input[@id='input-confirm']") 
	WebElement ConfirmPassword;
	
	@FindBy(xpath="//input[@type='checkbox']") 
	WebElement  PrivacyPolicy;
	
	@FindBy(xpath="//input[@class='btn btn-primary']") 
	WebElement  continueButton;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") 
	WebElement  msgConfirmation;
	
	
	public void setFirstName(String fname) 
	{
		Firstname.sendKeys(fname);

	}
	public void setLastName(String lname) 
	{
		Lastname.sendKeys(lname);
	}

	public void setEmail(String email)
	{
		Email.sendKeys(email);

	}

	public void setTelephone(String tel)
	{
		Telephone.sendKeys(tel);

	}

	public void setPassword(String pwd)
	{
		Password.sendKeys(pwd);

	}

	public void setConfirmPassword(String pwd)
	{
		ConfirmPassword.sendKeys(pwd);

	}

	public void clickPrivacyPolicy() 
	{
		PrivacyPolicy.click();

	}
	public void clickContinue() 
	{
		continueButton.click();
	}
	
	public String getconfirmmsg()
	{
		try
		{
			return (msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return  (e.getMessage());
		}
	}

	

	
}
