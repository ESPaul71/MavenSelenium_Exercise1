package TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import POM.CartPage;
import POM.TvPage;
import selenium.ClsBrowser;
import selenium.ClsReport;
import selenium.ClsWebElements;

public class TestCase1_AddToCart extends ClsWebElements{
	
	//First we initialize all constants than we need
		@Rule public TestName TC_Name = new TestName();
		public String URL = "http://live.guru99.com/index.php/tv.html"; 
		public String TvLG = "//a[contains(@title, 'LG LCD') and (text() = 'LG LCD')]";
		public By AddLGBtn = By.xpath("//button[contains(@onclick, 'product/4')]");
		
		public TvPage objTv = new TvPage();
		public CartPage objCart = new CartPage();
		
		
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
		public void FirstTC() throws Exception
		{
				ClsReport.objTest = ClsReport.objExtent.createTest("First Test");
				ClsReport.fnLog(Status.PASS, "First test Starting.", false);
				NavigateToUrl(URL); //go to Magento
				ClsReport.fnLog(Status.PASS, "Step - Go to" + URL, false);
				WaitForLoad();
				ClsReport.fnLog(Status.PASS, "Step -  Waiting for the page to load", false);
				objTv.VerifyTVSection();
				ClsReport.fnLog(Status.PASS, "Step - Check if we are in the TV section", false);
				objTv.VerifyItemExist(TvLG ,"LG LCD");
				ClsReport.fnLog(Status.PASS, "Step - Verify Tv exist.", true);
				objTv.AddToCart(AddLGBtn);
				ClsReport.fnLog(Status.PASS, "Step - Add Tv to cart.", false);
				WaitForLoad();
				ClsReport.fnLog(Status.PASS, "Step -  Waiting for the page to load", false);
				objCart.VerifyCartSection();
				ClsReport.fnLog(Status.PASS, "Step - Check if we are in the Shopping Cart section", false);
				objCart.VerifyAddItem("LG LCD");
				ClsReport.fnLog(Status.PASS, "Step - Verify that the item was added.", true);
				ClsReport.fnLog(Status.PASS, "Step - First test completed.", true);

		}
		
		//Close and finish the browser
		@After
		public void tearDown() 
		{
			CloseBrowser();
			ClsReport.fnCloseReport();
		}
}
