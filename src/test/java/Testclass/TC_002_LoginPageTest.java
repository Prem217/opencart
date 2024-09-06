package Testclass;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobject.Homepage;
import Pageobject.Loginpage;
import Pageobject.MyAccountpage;
import Testbase.baseclass;

public class TC_002_LoginPageTest extends baseclass{
	
	
	
	@Test(groups= {"regression","master"})
	public void verify_Login()
	{
		logger.info("*******************Starting TC_002_LoginPageTest *******************");
		try
		{
		Homepage hp=new Homepage(driver);
		hp.clickMyaccount();
		logger.info("click MyAccount link");
		hp.clickLogin();
		logger.info("click Login link");
		
		logger.info("enter Login details");
		Loginpage lp=new Loginpage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("clicked on ligin button..");
		
		MyAccountpage ap=new MyAccountpage(driver);
		boolean traget=ap.isMyAccountPageExists();
		
		if(traget==true) 
		{
			logger.info("*********LOGIN PASSED*******");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("**********************LOGIN FAILED*****************");
			Assert.fail();
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Finished TC_002_LoginTest  ****");
	}

}
