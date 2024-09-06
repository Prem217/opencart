package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage
{
	
	WebDriver driver;
	
	public Homepage(WebDriver driver)
	{
		super(driver);

	}
   

	@FindBy(xpath="(//a[@title='My Account'])")
	WebElement Myaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")       
	WebElement Registration;
	
	@FindBy(xpath="(//a[normalize-space()='Login'])[1]")       //(//a[normalize-space()='Login'])[1]
	WebElement Login;
	
	
	public void clickMyaccount()
	{
		Myaccount.click();
	}
	
	public void clickRegistration()
	{
		Registration.click();
	}
	
	
	public void clickLogin()
	{
		Login.click();
	}
	
	
	
	

	
}
