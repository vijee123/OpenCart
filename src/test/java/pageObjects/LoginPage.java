package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{

	  public LoginPage(WebDriver driver)
	  {
		  super(driver);
	  }
		
//----------------Locators -------------------	

	@FindBy(xpath="//input[@id='input-email']")
	@CacheLookup private
	WebElement eMail;
	
	@FindBy(xpath="//input[@id='input-password']")
	@CacheLookup
	private WebElement password;
	
	
	@FindBy(xpath="//input[@value='Login']") 
	@CacheLookup 
	private WebElement login;
	


//------------------Actions------------------------
	public void setEmail(String email)
	{
		eMail.sendKeys(email);
	}
	
	public void setPwd(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	
	public void clickLogin()
	{
		login.click();
	}


}
