package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	
	@Test(groups = {"sanity", "master"})
	public void verify_Login()
	{
		logger.info("*********TC_002_LoginTest started**********");
		logger.debug("Capturing application debug logs..........");
		
		try {
		//-----------------HomePage-----------------
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked MyAccount Link on Home page......");
		
		hp.clickLogin();
		logger.info("Clicked Login under My Account.......");
		
		//--------------Login Page--------------------------
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPwd(p.getProperty("password"));
		logger.info("Entered details on Login Page....");
		
		lp.clickLogin();
		logger.info("Clicked Login.....");
		
		//-----------------My Account Page----------------
		MyAccountPage map = new MyAccountPage(driver);
		boolean display = map.myAccountDisplay();
		
		if (display==true)
		{
			logger.info("Login Test Passed");
			Assert.assertTrue(true);	
		}
		else
		{
			logger.error("Login Failed");
			Assert.fail();	
		}
		}
		catch(Exception e)
		{
			Assert.fail();
			logger.error("Test Failed");
		}
		logger.info("*******TC_002_LoginTest completed*********");
		
	}
	
	
	
}
