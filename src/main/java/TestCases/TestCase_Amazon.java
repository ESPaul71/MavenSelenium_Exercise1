package TestCases;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.aventstack.extentreports.Status;

import POM.AmazonLogin;
import POM.LightningOffers;
import selenium.ClsBrowser;
import selenium.ClsReport;
import selenium.ClsWebElements;
import selenium.ExcelReport;

/**
 * 
 * @author paul
 *
 */
//This is the test than do all
public class TestCase_Amazon extends ClsWebElements {
	
	//First we initialize all constants than we need
	@Rule public TestName TC_Name = new TestName();
	public String URL = "https://www.amazon.com.mx/"; 
	public AmazonLogin objLogin = new AmazonLogin();
	public LightningOffers objOffers = new LightningOffers(); 
	
	//start report and excel file
	@BeforeClass
	public static void beforeClass() 
	{
		ClsReport.fnSetupReport();
		ExcelReport.StartExcelReport();
	}
	
	//Open the browser
	@Before
	public void setup() 
	{
		ClsBrowser.BrowserName = "Chrome";
		OpenBrowser();
	} 
	
	@Test 
	public void FirstTC() throws Exception
	{
			ClsReport.objTest = ClsReport.objExtent.createTest("First Test");
			ClsReport.fnLog(Status.PASS, "First test Starting.", false);
			NavigateToUrl(URL); //go to Amazon
			ClsReport.fnLog(Status.PASS, "Step - Go to" + URL, false);
			objLogin.idenify(); 
			ClsReport.fnLog(Status.INFO, "Step - Click in identify.", false);
			objLogin.enterEmail();
			ClsReport.fnLog(Status.PASS, "Step - Enter username.", false);
			objLogin.enterPassword();
			ClsReport.fnLog(Status.PASS, "Step - Enter password and click login button.", false);
			objLogin.VerifySession();
			ClsReport.fnLog(Status.PASS, "Step - Wait for the session to be verified.", true);
			objOffers.showLightningOffers();
			objOffers.GetListItems();
			ClsReport.fnLog(Status.PASS, "Step - Test completed.", true);

	}
	
	//Close and finish the browser
	@After
	public void tearDown() 
	{
		CloseBrowser();
		ClsReport.fnCloseReport();
	}
}
