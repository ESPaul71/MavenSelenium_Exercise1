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
import POM.CheckOutPage;
import POM.TvPage;
import selenium.ClsBrowser;
import selenium.ClsReport;
import selenium.ClsWebElements;

public class TestCase2_CheckOut extends ClsWebElements {

	//First we initialize all constants than we need
			@Rule public TestName TC_Name = new TestName();
			public String URL = "http://live.guru99.com/index.php/tv.html"; 
			public String TvSamsung = "//a[contains(@title, 'Samsung LCD') and (text() = 'Samsung LCD')]";
			public By AddLGBtn = By.xpath("//button[contains(@onclick, 'product/5')]");
			
			public TvPage objTv = new TvPage();
			public CartPage objCart = new CartPage();
			public CheckOutPage objCheckOut = new CheckOutPage();
			
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
					ClsReport.objTest = ClsReport.objExtent.createTest("Seccond Test");
					ClsReport.fnLog(Status.PASS, "First test Starting.", false);
					NavigateToUrl(URL); //go to Magento
					ClsReport.fnLog(Status.PASS, "Step - Go to" + URL, false);
					WaitForLoad();
					ClsReport.fnLog(Status.PASS, "Step -  Waiting for the page to load", false);
					objTv.VerifyTVSection();
					ClsReport.fnLog(Status.PASS, "Step - Check if we are in the TV section", false);
					objTv.VerifyItemExist(TvSamsung ,"SAMSUNG LCD");
					ClsReport.fnLog(Status.PASS, "Step - Verify Tv exist.", true);
					objTv.AddToCart(AddLGBtn);
					ClsReport.fnLog(Status.PASS, "Step - Add Tv to cart.", false);
					WaitForLoad();
					ClsReport.fnLog(Status.PASS, "Step -  Waiting for the page to load", false);
					objCart.VerifyCartSection();
					ClsReport.fnLog(Status.PASS, "Step - Check if we are in the Shopping Cart section", false);
					objCart.VerifyAddItem("SAMSUNG LCD");
					ClsReport.fnLog(Status.PASS, "Step - Verify that the item was added.", true);
					objCheckOut.GoToCheckOut();
					ClsReport.fnLog(Status.PASS, "Step - Go to CheckOut", false);
					objCheckOut.VerifyCheckOutSection();
					ClsReport.fnLog(Status.PASS, "Step - Check if we are in the CheckOut section", false);
					objCheckOut.VerifyCheckoutMethod();
					ClsReport.fnLog(Status.PASS, "Step - Check if we are in the CheckOut method section", false);
					objCheckOut.SelectAsGuest();
					ClsReport.fnLog(Status.PASS, "Step - Select CheckOut As Guest.", false);
					objCheckOut.VerifyBillingInformation();
					ClsReport.fnLog(Status.PASS, "Step - Check if we are in the Billing information section", false);
					objCheckOut.EnterFirstName();
					ClsReport.fnLog(Status.PASS, "Step - Enter first name.", false);
					objCheckOut.EnterMiddleName();
					ClsReport.fnLog(Status.PASS, "Step - Enter middle name.", false);
					objCheckOut.EnterLastName();
					ClsReport.fnLog(Status.PASS, "Step - Enter last name.", false);
					objCheckOut.EnterEmail();
					ClsReport.fnLog(Status.PASS, "Step - Enter email.", false);
					objCheckOut.EnterCompany();
					ClsReport.fnLog(Status.PASS, "Step - Enter company.", false);
					objCheckOut.EnterAddress();
					ClsReport.fnLog(Status.PASS, "Step - Enter address.", false);
					objCheckOut.EnterStreetAddress();
					ClsReport.fnLog(Status.PASS, "Step - Enter street address.", false);
					objCheckOut.EnterCity();
					ClsReport.fnLog(Status.PASS, "Step - Enter city.", false);
					objCheckOut.SelectState();
					ClsReport.fnLog(Status.PASS, "Step - Select state.", false);
					objCheckOut.EnterZip();
					ClsReport.fnLog(Status.PASS, "Step - Enter zip.", false);
					objCheckOut.SelectCountry();
					ClsReport.fnLog(Status.PASS, "Step - Select country.", false);
					objCheckOut.EnterTelephone();
					ClsReport.fnLog(Status.PASS, "Step - Enter telephone.", false);
					objCheckOut.EnterFax();
					ClsReport.fnLog(Status.PASS, "Step - Enter fax.", false);
					objCheckOut.SelectShipAddress();
					ClsReport.fnLog(Status.PASS, "Step - Select  ship address.", true);
					objCheckOut.BillingContinue();
					ClsReport.fnLog(Status.PASS, "Step - Click on continue button  in Billing information section.", false);
					objCheckOut.VerifyShippingMethod();
					ClsReport.fnLog(Status.PASS, "Step - Check if we are in the Shipping method section", false);
					objCheckOut.ShipingContinue();
					ClsReport.fnLog(Status.PASS, "Step - Click on continue button  in Shiping method section.", false);
					objCheckOut.VerifyPaymentInformation();
					ClsReport.fnLog(Status.PASS, "Step - Click on continue button  in Payment information section.", false);
					objCheckOut.SelectPayMethod();
					ClsReport.fnLog(Status.PASS, "Step - Select  money payment method.", false);
					objCheckOut.VerifyOrderReview();
					ClsReport.fnLog(Status.PASS, "Step - Check if we are in the Order review section", false);
					objCheckOut.VerifyProduct();
					ClsReport.fnLog(Status.PASS, "Step - Verify that the product is correct.", false);
					objCheckOut.EndOfCheckOut();
					ClsReport.fnLog(Status.PASS, "Step - Click on the Place Order button.", true);
					objCheckOut.VerifyEndCheckOut();
					ClsReport.fnLog(Status.PASS, "Step - Verify that the order has been successfully completed.", false);
					ClsReport.fnLog(Status.PASS, "Step - Second test completed.", true);

			}
			
			//Close and finish the browser
			@After
			public void tearDown() 
			{
				CloseBrowser();
				ClsReport.fnCloseReport();
			}
}
