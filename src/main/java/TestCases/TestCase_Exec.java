package TestCases;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.aventstack.extentreports.Status;
import POM.AtLoginPage;
import selenium.ClsBrowser;
import selenium.ClsReport;
import selenium.ClsWebElements;

public class TestCase_Exec extends ClsWebElements
{
	@Rule public TestName TC_Name = new TestName();
	public String URL = "https://positionsapp-uat.azurewebsites.net/#"; //I became this like a global variable because all test use and before all initialized the same url
	public AtLoginPage objLogin = new AtLoginPage(); //I became in a public variable because all test use and before all initialized the same object and was more code
	
	@BeforeClass
	public static void beforeClass() 
	{
		ClsReport.fnSetupReport();
	}
	
	@Before
	public void setup() 
	{
		ClsBrowser.BrowserName = "Chrome";
		OpenBrowser();
	} 
	
	
	@Test //put target Test
	public void FirstTC()
	{
		try 
		{
			ClsReport.objTest = ClsReport.objExtent.createTest("First Test");
			ClsReport.fnLog(Status.PASS, "First test Starting.", false);
			NavigateToUrl(URL);
			ClsReport.fnLog(Status.PASS, "Step - Go to" + URL, false);
			WaitForLoad();
			ClsReport.fnLog(Status.INFO, "Step - Wait for page load.", false);
			objLogin.enterCredential();
			ClsReport.fnLog(Status.PASS, "Step - Enter username.", false);
			objLogin.startSession();
			ClsReport.fnLog(Status.PASS, "Step - Enter password and click login button.", false);
			objLogin.keepSessionDialog();
			ClsReport.fnLog(Status.PASS, "Step - Click keep session button.", false);
			objLogin.verifyActiveSession();
			ClsReport.fnLog(Status.PASS, "Step - Wait for verify.", false);
			ClsReport.fnLog(Status.PASS, "First Test Completed.", true);
		}
		catch(Exception e) 
		{
			ClsReport.fnLog(Status.FAIL, "The: " + TC_Name.getMethodName() + " was not executed successfully. \n Exception: " + e.getMessage() , false);
		}
	}
		
		
	@Test //put target Test
	public void SecondTC()
	{
		try 
		{
			ClsReport.objTest = ClsReport.objExtent.createTest("Second Test");
			ClsReport.fnLog(Status.PASS, "Second test Starting.", false);
			NavigateToUrl(URL);
			ClsReport.fnLog(Status.PASS, "Step - Go to" + URL, false);
			WaitForLoad();
			ClsReport.fnLog(Status.INFO, "Step - Wait for page load.", false);
			objLogin.enterCredential();
			ClsReport.fnLog(Status.PASS, "Step - Enter username.", false);
			objLogin.startSession();
			ClsReport.fnLog(Status.PASS, "Step - Enter password and click login button.", false);
			objLogin.keepSessionDialog();
			ClsReport.fnLog(Status.PASS, "Step - Click keep session button.", false);
			objLogin.verifyActiveSession();
			ClsReport.fnLog(Status.PASS, "Step - Wait for verify.", false);
			ClsReport.fnLog(Status.PASS, "Second Test Completed.", true);
		}
		catch (Exception e) 
		{
			ClsReport.fnLog(Status.FAIL, "The: " + TC_Name.getMethodName() + " was not executed successfully. \n Exception: " + e.getMessage() , false);
		}
	}
	
	@Test //Remove comments
	public void NewTest()
	{
		try 
		{
			ClsReport.objTest = ClsReport.objExtent.createTest("Third Test");
			ClsReport.fnLog(Status.PASS, "Third test Starting.", false);
			NavigateToUrl(URL);
			ClsReport.fnLog(Status.PASS, "Step - Go to" + URL, false);
			WaitForLoad();
			ClsReport.fnLog(Status.INFO, "Step - Wait for page load.", false);
			objLogin.enterCredential();
			ClsReport.fnLog(Status.PASS, "Step - Enter username.", false);
			objLogin.startSession();
			ClsReport.fnLog(Status.PASS, "Step - Enter password and click login button.", false);
			objLogin.keepSessionDialog();
			ClsReport.fnLog(Status.PASS, "Step - Click keep session button.", false);
			objLogin.verifyActiveSession();
			ClsReport.fnLog(Status.PASS, "Step - Wait for verify.", false);
			ClsReport.fnLog(Status.PASS, "Third Test Completed.", true);
		}
		catch (Exception e) 
		{
			ClsReport.fnLog(Status.FAIL, "The: " + TC_Name.getMethodName() + " was not executed successfully. \n Exception: " + e.getMessage() , false);
		}
	}
	
	
	
	@After
	public void tearDown() 
	{
		CloseBrowser();
		ClsReport.fnCloseReport();
	}
	
	//This method is repeated and it's unnecessary
	/*@After 
	public void tearDown() 
	{
		CloseBrowser();
		ClsReport.fnCloseReport();
	}*/

}
