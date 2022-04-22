package POM;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import selenium.ClsWebElements;

public class CartPage extends ClsWebElements {
	
	//Constants
	public String Item = "//h2[@class='product-name']";
	public String Title = "//h1";
	
	
	public void VerifyAddItem(String name) {
		WaitForElement(Item);
		WebElement objItem = GetWebElement(Item);
		String currentItem = objItem.getAttribute("innerText");
		Assert.assertEquals(name, currentItem);
	}
	
	public void VerifyCartSection() 
	{
		WaitForLoad();
		WaitForElement(Title);
		WebElement objTitle = GetWebElement(Title);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals("SHOPPING CART", currentTitle);
	}
	
	
	
	
}
