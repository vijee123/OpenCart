package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups = {"regression", "master"})
	public void verify_Account_Registration() 
	{
		logger.info("*****TC_001_AccountRegistrationTest started running*****");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("My Account Link clicked...");
		
		hp.clickRegister();
		logger.info("Register Link clicked...");
		//Assert.assertEquals(driver.getTitle(), "Register Account", "The Registration webpage didnot open...");
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
		regPage.setFirstname(randomeString().toUpperCase());
		regPage.setLastname(randomeString().toUpperCase());
		regPage.setEmail(randomeString()+"@gmail.com");
		regPage.setTelephone(randomeNumber());
		
		String pwd = randomeAlphaNumeric();
		regPage.setPassword(pwd);
		regPage.confirmPassword(pwd);
		logger.info("AccountRegistrationPage information entered...");
		
		regPage.clickAgree();
		regPage.clickContinue();
		logger.info("Continue button clicked...");
		
		logger.info("Validating Confirmation Message...");
		
		String message = regPage.getConfirmationMessage();
		if (message.equals("Your Account Has Been Created!"))
			{
				logger.info("Test Passed...");
				Assert.assertTrue(true);
				logger.info("*****TC_001_AccountRegistrationTest completed*****");
			}
		else
			{
				logger.error("Test Failed...");
				Assert.fail();
				logger.info("*****TC_001_AccountRegistrationTest completed*****");
			}
		//Assert.assertEquals(regPage.getConfirmationMessage(), "Your Account Has Been Created!", "The account is not created..");
		} 
		catch (Exception e)
		{
			logger.error("Test Failed...");
			Assert.fail();
		}
		
				
	}
		
	
		
}
