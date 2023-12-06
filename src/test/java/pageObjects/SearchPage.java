package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SearchPage extends BasePage
{
	
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	
	//-----------LOCATORS--------------------

	private WebElement search = driver.findElement(By.xpath("//div[@id='product-search']//h1"));

	
	@FindBy(xpath="//div[@class='product-thumb']//div[@class='caption']//a")
	@CacheLookup 
	private List<WebElement> productsLinkListed;
	
	
			
	//----------------ACTIONS----------------------
	
	public boolean searchPageIsDisplayed()
	{
		String status = search.getText();
		if (status.contains("Search"))
		 return true;
		else
			return false;
	}
	

	public void getSearchProdListDisplayed()
		{
			try {
			for (WebElement j:productsLinkListed)
				{
						String myText = j.getText();
						System.out.println(myText);
						
				 }
			}catch(Exception e)
			{
				return;
			}
			
		}
	
	
	public int noOfProductsDisplayed()
	{
		int total_items = productsLinkListed.size();
		return total_items;
	}
	
	
	public void confirmSearchedProdNameInDisplayedProd(String itemName)
	{
	
		for(WebElement i:productsLinkListed)
			{
				String name = i.getText();
				if(name.contains(itemName))
				   {
					System.out.println("The displayed product "+name+" include name searched for: '"+itemName+"'");
					Assert.assertTrue(true);
				   }
				else
				  {
					System.out.println("The displayed product doesn't include name searched for...");
					Assert.fail();
				  }
			}
	 }
	

}
