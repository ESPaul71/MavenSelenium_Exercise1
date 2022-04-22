package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.ClsWebElements;

public class TvPage extends ClsWebElements{

	//Constants
	String Title = "//h1";
	
	
	
	
	
	public void AddToCart(By Item) {
		try {
				WaitForElementClickable(Item);
				Click(Item);
		}catch(Exception e) {
			
		}
	}
	
	public void VerifyTVSection() 
	{
		WaitForLoad();
		WaitForElement(Title);
		WebElement objTitle = GetWebElement(Title);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals("TV", currentTitle);
	}
	
	public void VerifyItemExist(String Item, String name) {
		WaitForElement(Item);
		WebElement objItem = GetWebElement(Item);
		String currentItem = objItem.getAttribute("innerText");
		Assert.assertEquals( name, currentItem);
	}
}
