package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.ClsWebElements;

public class CheckOutPage extends ClsWebElements {
	
	//Constants
	String Title = "//h1";
	String ConfirmationCheckOut = "//h1[text() = 'Your order has been received.']";
	String ProductName = "//h3[text() = 'Samsung LCD']";
	String CheckoutMethodTitle = "//h2[text() = 'Checkout Method']";
	String BillingInformationTitle = "//h2[text() = 'Billing Information']";
	String ShippingMethodTitle = "//h2[text() = 'Shipping Method']";
	String PaymentInformationTitle = "//h2[text() = 'Payment Information']";
	String OrderReviewTitle = "//h2[text() = 'Order Review']";
	
	String FirstName = "Ervin";
	String MiddleName = "Paul";
	String LastName = "Escobar Santos";
	String Company = "AgileThought";
	String Email = "paul17@hotmail.mx"; //Account email
	String Adress = "Morelo, 580";
	String StreetAddress = "Armonia";
	String City = "New York";
	String PostCode = "28000";
	String Telephone = "1287398493";
	String Fax = "575675757";
	
	By CheckOutBtn = By.xpath("//ul[@class = 'checkout-types top']");
	By CheckAsGuestBtn = By.xpath("//label[text() = 'Checkout as Guest']");
	By ContinueBtn = By.id("onepage-guest-register-button");
	By ShipAddressBtn = By.xpath("//label[text() = 'Ship to this address']");
	By BillingContinueBtn = By.xpath("//button[@title = 'Continue' and @onclick = 'billing.save()']");
	By ShipingContinueBtn = By.xpath("//button[@onclick = 'shippingMethod.save()']");
	By CheckMoneyOrder = By.xpath("//label[text() = 'Check / Money order ']");
	By PayMentContinueBtn =  By.xpath("//button[@onclick = 'payment.save()']");
	By PlaceOrderBtn = By.xpath("//button[@title = 'Place Order']");
	
	By FirstNameTxt = By.xpath("//input[@id='billing:firstname']");
	By MiddleNameTxt = By.xpath("//input[@id='billing:middlename']");
	By LastNameTxt = By.xpath("//input[@id='billing:lastname']");
	By CompanyTxt = By.xpath("//input[@id='billing:company']");
	By EmailTxt = By.xpath("//input[@id='billing:email']");
	By AddressTxt = By.xpath("//input[@id='billing:street1']");
	By StreetAddressTxt = By.xpath("//input[@id='billing:street2']");
	By CityTxt = By.xpath("//input[@id='billing:city']");
	By StateTxt = By.xpath("//select[@id='billing:region_id']");
	By StateOption = By.xpath("//option[@value='42' and text() = 'New Mexico']");
	By ZipTxt = By.xpath("//input[@id='billing:postcode']");
	By CountryTxt = By.xpath("//select[@id='billing:country_id']");
	By CountryOption = By.xpath("//option[@value='US' and text() = 'United States']");
	By TelephoneTxt = By.xpath("//input[@id='billing:telephone']");
	By FaxTxt = By.xpath("//input[@id='billing:fax']");
	
	
	public void GoToCheckOut() {
		WaitForElementClickable(CheckOutBtn);
		Click(CheckOutBtn);
	}
	
	public void VerifyCheckOutSection() {
		WaitForLoad();
		WaitForElement(Title);
		WebElement objTitle = GetWebElement(Title);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals("CHECKOUT", currentTitle);
	}
	
	public void SelectAsGuest() {
		WaitForElementClickable(CheckAsGuestBtn);
		Click(CheckAsGuestBtn);
		WaitForElementClickable(ContinueBtn);
		Click(ContinueBtn);
	}
	
	public void EnterFirstName(){
		WaitForElementClickable(FirstNameTxt);
		SendKeys(FirstNameTxt, FirstName);
	}
	
	public void EnterMiddleName(){
		WaitForElementClickable(MiddleNameTxt);
		SendKeys(MiddleNameTxt, MiddleName);
	}
	
	public void EnterLastName(){
		WaitForElementClickable(LastNameTxt);
		SendKeys(LastNameTxt, LastName);
	}
	
	//Put the email and click in continue button
	public void EnterEmail(){
			WaitForElementClickable(EmailTxt);
			SendKeys(EmailTxt, Email);
	}
	
	public void EnterCompany(){
		WaitForElementClickable(CompanyTxt);
		SendKeys(CompanyTxt, Company);
	}
	
	public void EnterAddress(){
		WaitForElementClickable(AddressTxt);
		SendKeys(AddressTxt, Adress);
	}
	
	public void EnterStreetAddress(){
		WaitForElementClickable(StreetAddressTxt);
		SendKeys(StreetAddressTxt, StreetAddress);
	}
	
	public void EnterCity(){
		WaitForElementClickable(CityTxt);
		SendKeys(CityTxt, City);
	}
	
	public void SelectState() {
		WaitForElementClickable(StateTxt);
		Click(StateTxt);
		WaitForElementClickable(StateOption);
		Click(StateOption);
	}
	
	public void EnterZip(){
		WaitForElementClickable(ZipTxt);
		SendKeys(ZipTxt, PostCode);
	}
	
	public void SelectCountry() {
		WaitForElementClickable(CountryTxt);
		Click(CountryTxt);
		WaitForElementClickable(CountryOption);
		Click(CountryOption);
	}
	
	public void EnterTelephone(){
		WaitForElementClickable(TelephoneTxt);
		SendKeys(TelephoneTxt, Telephone);
	}
	
	public void EnterFax(){
		WaitForElementClickable(FaxTxt);
		SendKeys(FaxTxt, Fax);
	}
	
	public void SelectShipAddress() {
		WaitForElementClickable(ShipAddressBtn);
		Click(ShipAddressBtn);
	}
	
	public void BillingContinue() {
		WaitForElementClickable(BillingContinueBtn);
		Click(BillingContinueBtn);
	}
	
	public void ShipingContinue() {
		WaitForElementClickable(ShipingContinueBtn);
		Click(ShipingContinueBtn);
	}
	
	public void SelectPayMethod(){
		WaitForElementClickable(CheckMoneyOrder);
		Click(CheckMoneyOrder);
		WaitForElementClickable(PayMentContinueBtn);
		Click(PayMentContinueBtn);
	}
	
	public void VerifyProduct() {
		WaitForLoad();
		WaitForElement(ProductName);
		WebElement objTitle = GetWebElement(ProductName);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals("SAMSUNG LCD", currentTitle);
	}
	
	public void EndOfCheckOut() {
		WaitForElementClickable(PlaceOrderBtn);
		Click(PlaceOrderBtn);
	}
	
	public void VerifyEndCheckOut() {
		WaitForLoad();
		WaitForElement(ConfirmationCheckOut);
		WebElement objTitle = GetWebElement(ConfirmationCheckOut);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals("YOUR ORDER HAS BEEN RECEIVED.", currentTitle);
	}
	
	public void VerifyBillingInformation() {
		WaitForLoad();
		WaitForElement(BillingInformationTitle);
		WebElement objTitle = GetWebElement(BillingInformationTitle);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals("BILLING INFORMATION", currentTitle);
	}
	
	public void VerifyCheckoutMethod() {
		WaitForLoad();
		WaitForElement(CheckoutMethodTitle);
		WebElement objTitle = GetWebElement(CheckoutMethodTitle);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals("CHECKOUT METHOD", currentTitle);
	}
	
	public void VerifyShippingMethod() {
		WaitForLoad();
		WaitForElement(ShippingMethodTitle);
		WebElement objTitle = GetWebElement(ShippingMethodTitle);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals("SHIPPING METHOD", currentTitle);
	}
	
	public void VerifyPaymentInformation() {
		WaitForLoad();
		WaitForElement(PaymentInformationTitle);
		WebElement objTitle = GetWebElement(PaymentInformationTitle);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals("PAYMENT INFORMATION", currentTitle);
	}
	
	public void VerifyOrderReview() {
		WaitForLoad();
		WaitForElement(OrderReviewTitle);
		WebElement objTitle = GetWebElement(OrderReviewTitle);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals("ORDER REVIEW", currentTitle);
	}

}
