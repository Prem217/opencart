package Testclass;


import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobject.Homepage;
import Pageobject.RegistrationPage;
import Testbase.baseclass;

public class TC_001_AccountRegistrationTest extends baseclass {
	
	
	@Test (groups= {"sanity","master"})
	public void verify_account_registration()
	{
		logger.info("**********Starting TC_001_AccountRegistrationTest********************");
		logger.debug("application logs started......");
		try
		{
		Homepage hp=new Homepage(driver);
		hp.clickMyaccount();
		logger.info("clicked MyAccount link");
		hp.clickRegistration();
		logger.info("clicked Registration link");
	
	
		logger.info("Entering customer details.. ");
		RegistrationPage rp=new RegistrationPage(driver);
		rp.setFirstName(randomestring().toUpperCase());
		rp.setLastName(randomestring().toLowerCase());
		rp.setEmail(randomestring()+"@gmail.com");
		rp.setTelephone(randomnumber());
		
		String Password=randomalphanumeric();
		rp.setPassword(Password);
		rp.setConfirmPassword(Password);
		
		rp.clickPrivacyPolicy();
		rp.clickContinue();
		String confirm=rp.getconfirmmsg();
		Assert.assertEquals(confirm, "Your Account Has Been Created!!!");
		}
		catch(Exception e)
		{
			logger.error("test failed..");
			logger.debug("debug logs....");
			Assert.fail();
		}
		logger.debug("application logs end.......");
		logger.info("**** finished TC_001_AccountRegistrationTest  *****");
		}
		

	}


