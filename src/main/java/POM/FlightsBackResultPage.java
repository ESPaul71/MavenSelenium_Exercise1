package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.ClsWebElements;

public class FlightsBackResultPage extends ClsWebElements {
	
	
	String FlightsResultBackTitle = "//h3[@class = 'ng-star-inserted' and text() = 'Elige tu vuelo de regreso de']";
	By BasicPackBack = By.xpath("(//span[@class = 'faretype-m'])[1]");
	By PriceFlightBackBtn = By.xpath("(//a[@class='panel-open ng-star-inserted'])[1]");
	
	public void VerifyFlightsResultBackSection() 
	{
		WaitForLoad();
		WaitForElement(FlightsResultBackTitle);
		WebElement objTitle = GetWebElement(FlightsResultBackTitle);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals("Elige tu vuelo de regreso de", currentTitle);
	}
	
	public void SelectBackFlight() throws InterruptedException {
		WaitForElementClickable(PriceFlightBackBtn);
		Click(PriceFlightBackBtn);
		WaitForElementClickable(BasicPackBack);
		Click(BasicPackBack);
	}

}
