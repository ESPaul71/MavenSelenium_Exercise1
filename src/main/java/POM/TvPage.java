package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import selenium.ClsReport;
import selenium.ClsWebElements;

public class TvPage extends ClsWebElements{

	//Constants
	String Title = "//h1";
	
	
	
	
	
	public void AddToCart(By Item) {
				WaitForElementClickable(Item);
				Click(Item);
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
		try {
			WaitForElement(Item);
			WebElement objItem = GetWebElement(Item);
			String currentItem = objItem.getAttribute("innerText");
			Assert.assertEquals( name, currentItem);
		}catch(Exception e) {
			ClsReport.fnLog(Status.FAIL, "Error: " + e.getMessage(), false);
			System.out.println(e);
		}

	}
}
