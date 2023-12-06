package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass
{
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	public void verify_Login_DDT(String email, String pwd, String exp)
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
		lp.setEmail(email);
		lp.setPwd(pwd);
		logger.info("Entered details on Login Page....");
		
		lp.clickLogin();
		logger.info("Clicked Login.....");
		
		//-----------------My Account Page----------------
		MyAccountPage map = new MyAccountPage(driver);
		boolean display = map.myAccountDisplay();
		System.out.println(display);
		
		if (exp.equalsIgnoreCase("Valid"))
		{
			if (display==true)
			{
				map.clickLogout();
				Assert.assertTrue(true);
				logger.info("Test Passed");
			}
			else
			{
				Assert.fail();
				logger.error("Test Failed");
			}
		}
		
		if (exp.equalsIgnoreCase ("Invalid"))
		{
			
			if (display==true)
			{
				map.clickLogout();
				Assert.assertTrue(false);
				logger.error("Test Failed");
			}
			else 
			{
				Assert.assertTrue(true);
				logger.info("Test Passed");
			}
		}
	
		}
		catch(Exception e)
		{
			Assert.fail();
			logger.error("Test Failed");
		}
		logger.info("*******TC_003_LoginDDT Test completed*********");
		
	}
	
	
	

}
