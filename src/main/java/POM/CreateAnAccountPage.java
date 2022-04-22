package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.ClsWebElements;

public class CreateAnAccountPage extends ClsWebElements{
	
	//Constants
	String FirstName = "Ervin";
	String MiddleName = "Paul";
	String LastName = "Escobar Santos";
	String Email = "paul27@hotmail.mx"; //Account email
	String Password = "HolaMundo1";//Account password
	String Title = "//h1";
	String Header = "//p[@class='welcome-msg']";
	
	
	By AccountBtn = By.xpath("//div[@class='account-cart-wrapper']");
	By RegisterBtn = By.xpath("//a[@title='Register']");
	By RegisterAccountBtn = By.xpath("//button[@title = 'Register']");

	By FirstNameTxt = By.xpath("//input[@id='firstname']");
	By MiddleNameTxt = By.xpath("//input[@id='middlename']");
	By LastNameTxt = By.xpath("//input[@id='lastname']");
	By EmailTxt = By.xpath("//input[@id='email_address']");
	By PasswordTxt = By.xpath("//input[@id='password']");
	By PasswordVerifyTxt = By.xpath("//input[@id='confirmation']");
	
	
	public void GoToRegister() {
		WaitForElementClickable(AccountBtn);
		Click(AccountBtn);
		WaitForElementClickable(RegisterBtn);
		Click(RegisterBtn);
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
		
	public void EnterPassword(){
			WaitForElementClickable(PasswordTxt);
			SendKeys(PasswordTxt, Password);
	}
	
	public void EnterPasswordVerify(){
		WaitForElementClickable(PasswordVerifyTxt);
		SendKeys(PasswordVerifyTxt, Password);
	}
	
	public void RegisterAccount() {
		WaitForElementClickable(RegisterAccountBtn);
		Click(RegisterAccountBtn);
	}
	
	public void VerifyRegisterSection() {
		WaitForLoad();
		WaitForElement(Title);
		WebElement objTitle = GetWebElement(Title);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals("CREATE AN ACCOUNT", currentTitle);
	}
	
	public void VerifyActiveSession() {
		WaitForLoad();
		WaitForElement(Header);
		WebElement objTitle = GetWebElement(Header);
		String currentTitle = objTitle.getAttribute("innerText");
		Assert.assertEquals("WELCOME, ERVIN PAUL ESCOBAR SANTOS!", currentTitle);

	}
}
