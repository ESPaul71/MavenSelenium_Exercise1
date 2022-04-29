package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.ClsWebElements;

public class FlightsPage extends ClsWebElements {
	
	//Constants
	
	String AirportOrigin = "Guadalajara";
	String AirportDestination = "Cancún";
	
	String SectionTitle = "//div[@class = 'label ng-star-inserted' and text() = 'Vuelos']";
	
	By OriginBtn = By.xpath("//div[@class = 'col btnSearch SearchOrigin']");
	By AirportOriginTxt = By.xpath("//input[@id = 'fnameOrigin']");
	By AirportOriginBtn =  By.xpath("//div[@class = 'col-10 left-align' and text() = 'Guadalajara']");
	
	By DestinationBtn = By.xpath("//div[@class = 'col btnSearch SearchDestination']");
	By AirportDestinationTxt = By.xpath("//input[@id = 'fnameDestination']");
	By AirportDestinationBtn =  By.xpath("//div[@class = 'col-10 left-align' and text() = 'Cancún']");
	
	By GoDate = By.xpath("//input[@id = 'mat-input-5']");
	
	By BackDate = By.xpath("//input[@id = 'mat-input-6']");
	
	By GoMonthSelect = By.xpath("//div[@class = 'dropdowns ng-star-inserted' and text() = ' abril ']");
	By GoMonthOption = By.xpath("//option[@class = 'ng-star-inserted' and text() = ' octubre ']");
	By GoDay = By.xpath("//td[@class = 'weekend datecell-20221029 customfare available']");
	
	By BackMonthSelect = By.xpath("//div[@class = 'dropdowns ng-star-inserted' and text() = ' mayo ']");
	By BackMonthOption = By.xpath("//div[@class = 'ng-star-inserted' and text() = ' noviembre ']");
	By BackDay = By.xpath("//td[@class = 'datecell-20221104 returnVisible returnCustomfare available']");
	
	By HechoBtn = By.xpath("//button[@class = 'btn-calendar d-none d-md-block mat-flat-button mat-button-base mat-secondary']");
	
	By SearchFlight = By.xpath("//span[@class = 'mat-button-wrapper' and text() = ' Buscar vuelos ']");
	
	By FlightsResult = By.xpath("//div[@class = 'flightItem ng-star-inserted']");
	
	
	public void VerifyFlightsSection() 
	{
		WaitForLoad();
		WaitForElement(SectionTitle);
		WebElement objTitle = GetWebElement(SectionTitle);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals("Vuelos", currentTitle);
	}
	
	public void SelectOriginAirport() throws Throwable {
		
		WaitForElementClickable(OriginBtn);
		Click(OriginBtn);
		WaitForElementClickable(AirportOriginTxt);
		Thread.sleep(2000);
		SendKeys(AirportOriginTxt, AirportOrigin);
		WaitForElementClickable(AirportOriginBtn);
		Click(AirportOriginBtn);
	}
	
	public void SelectDestinationAirport() {
		WaitForElementClickable(DestinationBtn);
		Click(DestinationBtn);
		WaitForElementClickable(AirportDestinationTxt);
		SendKeys(AirportDestinationTxt, AirportDestination);
		WaitForElementClickable(AirportDestinationBtn);
		Click(AirportDestinationBtn);
	}
	
	public void SelectDateGo() {
		WaitForElementClickable(GoDate);
		Click(GoDate);
		WaitForElementClickable(GoMonthSelect);
		Click(GoMonthSelect);
		WaitForElementClickable(GoMonthOption);
		Click(GoMonthOption);
		WaitForElementClickable(GoDay);
		Click(GoDay);
	}
	
	public void SelectDateBack() {
		WaitForElementClickable(BackDay);
		Click(BackDay);
		WaitForElementClickable(HechoBtn);
		Click(HechoBtn);
	}
	
	public void SearchFlight() {
		WaitForElementClickable(SearchFlight);
		Click(SearchFlight);
	}

}
