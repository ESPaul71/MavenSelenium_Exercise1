package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.ClsWebElements;

public class FlightsResultPage extends ClsWebElements {

	String FlightsResultTitle = "//h1[@class = 'ng-star-inserted' and text() = 'Elige tu vuelo de salida de']";
	
	
	By SelectOrder = By.xpath("//select[@id = 'mat-input-10']");
	By CheapOption = By.xpath("//option[@class = 'ng-star-inserted' and text() = ' Precio (más barato)']");
	By PriceFlightBtn = By.xpath("(//a[@class='panel-open ng-star-inserted'])[1]");
	By BasicPackGo = By.xpath("(//span[@class='faretype-m' and text() = 'Básica '])[1]");

	
	public void VerifyFlightsResultSection() 
	{
		WaitForLoad();
		WaitForElement(FlightsResultTitle);
		WebElement objTitle = GetWebElement(FlightsResultTitle);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals("Elige tu vuelo de salida de", currentTitle);
	}
	
	public void OrderResult() throws InterruptedException {
		WaitForElementClickable(SelectOrder);
		Click(SelectOrder);
		WaitForElementClickable(CheapOption);
		Click(CheapOption);
	}
	
	public void SelectFlight() {
		WaitForElementClickable(PriceFlightBtn);
		Click(PriceFlightBtn);
		WaitForElementClickable(BasicPackGo);
		Click(BasicPackGo);
	}
}
