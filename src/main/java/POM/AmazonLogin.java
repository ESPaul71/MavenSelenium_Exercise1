package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.ClsWebElements;
 /**
  * 
  * @author paul
  *
  */
public class AmazonLogin extends ClsWebElements {
	
	//Constant
	String Email = "paulesantos@hotmail.com"; //Account email
	String Password = "Niñoguero1177";//Account password
	String NumberTitle = "//h1";
	String SkipBtn = "//a[@id='ap-account-fixup-phone-skip-link']";
	String IdentifyBtn = "//a[@id='nav-link-accountList']";
	String AccountName = "//span[@id = 'nav-link-accountList-nav-line-1']";
	
	By UserNameTxt = By.xpath("//input[@id='ap_email']");
	By PasswordTxt = By.xpath("//input[@id='ap_password']");
	By ContinueBtn = By.xpath("//input[@id='continue']");
	By SingInBtn = By.xpath("//input[@id='signInSubmit']");

	
	
	
	
	//Methods
	
	//Click in Identify button for Log In
	public void idenify() {
		WaitForLoad();
		Click(IdentifyBtn);
	}
	
	//Put the email and click in continue button
	public void enterEmail(){
		WaitForLoad();
		SendKeys(UserNameTxt, Email);
		Click(ContinueBtn);
	}
	
	//Put password and click in SingIn button
	public void enterPassword(){
		WaitForLoad();
		SendKeys(PasswordTxt, Password);
		Click(SingInBtn);
	}
	
	//This method is to verify that the session was successfully logged in.
	public void VerifySession() {
		WaitForLoad();
		WaitForElement(AccountName);
		WebElement objTitle = GetWebElement(AccountName);
		String currentTitle = objTitle.getAttribute("innerText");
		try{
			Assert.assertEquals("Hola Ervin", currentTitle);
		}catch(Exception e) {
			System.out.println("Your session is not start");
		}
		
	}
}
