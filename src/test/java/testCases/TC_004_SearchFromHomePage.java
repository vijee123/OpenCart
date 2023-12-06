package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_004_SearchFromHomePage extends BaseClass
{
	@Test(groups = {"regression", "master"})
	public void searchProduct()
	{
		HomePage hp = new HomePage(driver);
		hp.setSearchItem(p.getProperty("myitem"));
		hp.clickSearchIcon();
		
		SearchPage sp = new SearchPage(driver);
		boolean status = sp.searchPageIsDisplayed();
		System.out.println("The search page is displayed: "+status);
		//Assert.assertEquals(status, true, "Search page is not opened");
		
		System.out.println("Total no of matching items are: "+sp.noOfProductsDisplayed());
		
		System.out.println("The Items name listed are: ");
		sp.getSearchProdListDisplayed();
		
		sp.confirmSearchedProdNameInDisplayedProd(p.getProperty("myitem"));			
		
	}
	
	
	

}
