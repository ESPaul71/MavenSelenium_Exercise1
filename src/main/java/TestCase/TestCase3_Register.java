package TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.aventstack.extentreports.Status;

import POM.CreateAnAccountPage;
import POM.TvPage;
import selenium.ClsBrowser;
import selenium.ClsReport;
import selenium.ClsWebElements;

public class TestCase3_Register extends ClsWebElements{
	
	//First we initialize all constants than we need
			@Rule public TestName TC_Name = new TestName();
			public String URL = "http://live.guru99.com/index.php/tv.html"; 
			
			public TvPage objTv = new TvPage();
			public CreateAnAccountPage objCreate = new CreateAnAccountPage();
			
			
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
			public void ThirdTC() throws Exception
			{
				try {
					
				
					ClsReport.objTest = ClsReport.objExtent.createTest("Third Test");
					ClsReport.fnLog(Status.PASS, "Third test Starting.", false);
					NavigateToUrl(URL); //go to Magento
					ClsReport.fnLog(Status.PASS, "Step - Go to" + URL, false);
					WaitForLoad();
					ClsReport.fnLog(Status.PASS, "Step -  Waiting for the page to load", false);
					objTv.VerifyTVSection();
					ClsReport.fnLog(Status.PASS, "Step - Check if we are in the TV section", false);
					objCreate.GoToRegister();
					ClsReport.fnLog(Status.PASS, "Step - Go to register", false);
					objCreate.VerifyRegisterSection();
					ClsReport.fnLog(Status.PASS, "Step - Check if we are in the Register section", true);
					objCreate.EnterFirstName();
					ClsReport.fnLog(Status.PASS, "Step - Enter first name.", false);
					objCreate.EnterMiddleName();
					ClsReport.fnLog(Status.PASS, "Step - Enter middle name.", false);
					objCreate.EnterLastName();
					ClsReport.fnLog(Status.PASS, "Step - Enter last name.", false);
					objCreate.EnterEmail();
					ClsReport.fnLog(Status.PASS, "Step - Enter email.", false);
					objCreate.EnterPassword();
					ClsReport.fnLog(Status.PASS, "Step - Enter password.", false);
					objCreate.EnterPasswordVerify();
					ClsReport.fnLog(Status.PASS, "Step - Enter confirm password .", false);
					objCreate.RegisterAccount();
					ClsReport.fnLog(Status.PASS, "Step - Click in register account button.", false);
					objCreate.VerifyActiveSession();
					ClsReport.fnLog(Status.PASS, "Step - Check if the account was register.", false);
					ClsReport.fnLog(Status.PASS, "Step - Third test completed.", true);
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
