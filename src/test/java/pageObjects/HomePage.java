package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//HomePage Elements Locators
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	@CacheLookup
	private WebElement myAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	@CacheLookup 
	private WebElement register;
	
	@FindBy(xpath="//a[normalize-space()='Login']") 
	@CacheLookup
	private WebElement login;
	

	@FindBy(xpath="//input[@placeholder='Search']")
	@CacheLookup 
	private WebElement search;	
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	@CacheLookup 
	private WebElement searchIcon;
	
	
	
	//Actions
	public void clickMyAccount()
	{
		myAccount.click();
	}
	
	public void clickRegister()
	{
		register.click();
	}
	
	public void clickLogin()
	{
		login.click();
	}
	
	public void setSearchItem(String prod)
	{
		search.sendKeys(prod);
	}
	
	public void clickSearchIcon()
	{
		searchIcon.click();
	}
	
	
}
