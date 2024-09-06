package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage{

	public Loginpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement EmailAddress;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement Password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement Login;


	public void setEmail(String email) {
		EmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) {
		Password.sendKeys(pwd);
	}

	public void clickLogin() {
		Login.click();
	}

	

}
