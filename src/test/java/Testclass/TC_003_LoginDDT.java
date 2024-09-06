package Testclass;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobject.Homepage;
import Pageobject.Loginpage;
import Pageobject.MyAccountpage;
import Testbase.baseclass;

import utilities.DataProviders;


/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC_003_LoginDDT extends baseclass 
{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String password, String exp)
	{
		logger.info("**** Starting TC_003_LoginDDT *****");
		
		try {
	
		//Home page
			Homepage hp=new Homepage(driver);
			hp.clickMyaccount();
			logger.info("click MyAccount link");
			hp.clickLogin();
			logger.info("click Login link");
			
			logger.info("enter Login details");
			Loginpage lp=new Loginpage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();
			logger.info("clicked on ligin button..");
			
			MyAccountpage ap=new MyAccountpage(driver);
			boolean traget=ap.isMyAccountPageExists();
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(traget==true)
				{
					ap.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(traget==true)
				{
					ap.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
			
		logger.info("**** Finished TC_003_LoginDDT *****");
	}
	
}








