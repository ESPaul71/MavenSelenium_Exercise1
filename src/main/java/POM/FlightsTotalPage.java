package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import selenium.ClsReport;
import selenium.ClsWebElements;

public class FlightsTotalPage extends ClsWebElements {
	
	String FlightsTotal = "//h1[text() = 'Vuelos seleccionados']";
	By CheckTUA = By.xpath("//div[@class = 'mat-checkbox-inner-container']");
	String TotalPrice = "//div[@class = 'item GrandTotal grand-total-pulse-animation']//following-sibling::div[not(contains(@class,'grand-total-price-msg')) and not(contains(@class ,'clearfix'))]";


	By ConfirmBaggageBtn = By.xpath("//span[@class='mat-button-wrapper' and text() = 'Confirmar selección']");
	
	public void VerifySelectedFlightsSection() 
	{
		WaitForLoad();
		WaitForElement(FlightsTotal);
		WebElement objTitle = GetWebElement(FlightsTotal);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals("Vuelos seleccionados", currentTitle);
	}
	
	public void ConfirmBaggage() {
		WaitForElementClickable(ConfirmBaggageBtn);
		Click(ConfirmBaggageBtn);
	}
	
	public void AddTUA() {
		Scroll(CheckTUA);
		WaitForElementClickable(CheckTUA);
		Click(CheckTUA);
	}
	public boolean CheckPrice() {
		WaitForElement(TotalPrice);
		WebElement objPrice = GetWebElement(TotalPrice);
		ClsReport.fnLog(Status.PASS, "Step - Get the total price in a string", false);
		String currenPrice = objPrice.getAttribute("innerText");
		currenPrice = currenPrice.replaceAll("MXN", "");
		currenPrice = currenPrice.replaceAll(",", "");
		currenPrice = currenPrice.replaceAll("$", "");
		currenPrice = currenPrice.replaceAll(" ", "");
		System.out.println(currenPrice);
		String Price = currenPrice.substring(1, currenPrice.length());
		ClsReport.fnLog(Status.PASS, "Step - eliminate everything that is not a number", false);
		System.out.println(Price);
		int PriceInt = Integer.parseInt(Price);
		ClsReport.fnLog(Status.PASS, "Step - convert string to integer", false);
		System.out.println(PriceInt-1500);
		if(PriceInt <= 1500) {
			return true;
			
		}else {
			return false;
		}
	}
}
