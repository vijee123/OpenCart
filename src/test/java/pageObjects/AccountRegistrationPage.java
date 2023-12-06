package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//-------------locators--------------------
	@FindBy(xpath="//input[@id='input-firstname']")
	@CacheLookup
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	@CacheLookup
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	@CacheLookup
	private WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	@CacheLookup 
	private WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	@CacheLookup 
	private WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	@CacheLookup
	private WebElement pwdConfirm;
	
	@FindBy(xpath="//input[@name='agree']")
	@CacheLookup
	private WebElement agree;
	
	@FindBy(xpath="//input[@value='Continue']")
	@CacheLookup
	private WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	@CacheLookup
	private WebElement confirmationMessage;
	
	//---------------Action Methods-----------------
	public void setFirstname(String fName)
	{
		firstName.sendKeys(fName);
	}
	
	public void setLastname(String lName)
	{
		lastName.sendKeys(lName);
	}
	
	public void setEmail(String Email)
	{
		email.sendKeys(Email);
	}
	
	public void setTelephone(String phoneNo)
	{
		telephone.sendKeys(phoneNo);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void confirmPassword(String pwd)
	{
		pwdConfirm.sendKeys(pwd);
	}
	
	public void clickAgree()
	{
		agree.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
		
	public String getConfirmationMessage()
	{
		try {
		return(confirmationMessage.getText());
		} catch (Exception e) {
		return (e.getMessage());
		}
	}
	
		
	
}
