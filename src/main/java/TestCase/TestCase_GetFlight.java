package TestCase;

import selenium.ClsWebElements;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import POM.FlightsBackResultPage;
import POM.FlightsPage;
import POM.FlightsResultPage;
import POM.FlightsTotalPage;
import selenium.ClsBrowser;
import selenium.ClsReport;

public class TestCase_GetFlight extends ClsWebElements {
	

	//First we initialize all constants than we need
	@Rule public TestName TC_Name = new TestName();
	public String URL = "https://www.volaris.com/"; 
	
	public FlightsPage objFlight = new FlightsPage();
	public FlightsResultPage objResult = new FlightsResultPage();
	public FlightsBackResultPage objBackResult = new FlightsBackResultPage();
	public FlightsTotalPage objTotal = new FlightsTotalPage();

	By ListFlightsGoResult = By.xpath("//div[@class = 'row no-gutters flightItemDetails']");
	By ListFlightsBackResult = By.xpath("//div[@class = 'flightItem ng-star-inserted']");
	
	
	//start report and excel file
	@BeforeClass
	public static void beforeClass() 
	{
		ClsReport.fnSetupReport();
	}
	
	//Open the browser
	@Before
	public void setup() 
	{
		ClsBrowser.BrowserName = "Chrome";
		OpenBrowser();
	} 
	
	@Test 
	public void FirstTC() throws Throwable
	{
		try {
			ClsReport.objTest = ClsReport.objExtent.createTest("First Test");
			ClsReport.fnLog(Status.PASS, "First test Starting.", false);
			NavigateToUrl(URL); //go to Magento
			ClsReport.fnLog(Status.PASS, "Step - Go to" + URL, false);
			WaitForLoad();
			ClsReport.fnLog(Status.PASS, "Step -  Waiting for the page to load", false);
			objFlight.VerifyFlightsSection();
			ClsReport.fnLog(Status.PASS, "Step - Check if we are in the Flights section", false);
			objFlight.SelectOriginAirport();
			ClsReport.fnLog(Status.PASS, "Step - Select the airport of origin ", false);
			objFlight.SelectDestinationAirport();
			ClsReport.fnLog(Status.PASS, "Step - Select destination airport ", false);
			objFlight.SelectDateGo();
			ClsReport.fnLog(Status.PASS, "Step - Selecting the first date ", false);
			objFlight.SelectDateBack();
			ClsReport.fnLog(Status.PASS, "Step - Selecting the return date ", true);
			objFlight.SearchFlight();
			ClsReport.fnLog(Status.PASS, "Step - Search flights", false);
			WaitForLoad();
			ClsReport.fnLog(Status.PASS, "Step -  Waiting for the page to load", false);
			objResult.VerifyFlightsResultSection();
			ClsReport.fnLog(Status.PASS, "Step - Check if we are in the Flights result section", true);
			List<WebElement> myElementsGo = getWebList(ListFlightsGoResult);
			ClsReport.fnLog(Status.PASS, "Step - Verify that exist First flights", false);
			if(myElementsGo.isEmpty() == false) {
				objResult.OrderResult();
				ClsReport.fnLog(Status.PASS, "Step - order the results from the cheapest to the most expensive", false);
				objResult.SelectFlight();
				ClsReport.fnLog(Status.PASS, "Step - Select the flight to go GDL - CUN", false);
				List<WebElement> myElementsBack = getWebList(ListFlightsBackResult);
				objBackResult.VerifyFlightsResultBackSection();
				ClsReport.fnLog(Status.PASS, "Step - Check if we are in return flights section", true);
				ClsReport.fnLog(Status.PASS, "Step - Verify that exist return flights", false);
				if(myElementsBack.isEmpty() == false) {
					objBackResult.SelectBackFlight();
					ClsReport.fnLog(Status.PASS, "Step - Select the flight to go CUN - GDL", false);
					objTotal.VerifySelectedFlightsSection();
					ClsReport.fnLog(Status.PASS, "Step - Check if we are in flights selected section", true);
					objTotal.ConfirmBaggage();
					ClsReport.fnLog(Status.PASS, "Step - Confirm our baggage", false);
					objTotal.AddTUA();
					ClsReport.fnLog(Status.PASS, "Step - Check TUA", false);
					ClsReport.fnLog(Status.PASS, "Step - Check if the total price is within our budget.", false);
					if(objTotal.CheckPrice() == true) {
						ClsReport.fnLog(Status.PASS, "Step - First test completed.", true);
					}else {
						ClsReport.fnLog(Status.FAIL, "Total price exceeds our budget.", true);
					}
				}else {
					ClsReport.fnLog(Status.FAIL, "Step - No found return flight", false);
				}
				
			}else {
				ClsReport.fnLog(Status.FAIL, "Step - No found first flight", false);
			}
			
		}catch (Exception e) {
			ClsReport.fnLog(Status.FAIL, "Error: " + e.getMessage(), false);
		}

	}
	
	//Close and finish the browser
	@After
	public void tearDown() 
	{
		CloseBrowser();
		ClsReport.fnCloseReport();
	}
}
