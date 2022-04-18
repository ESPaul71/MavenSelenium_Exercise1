package POM;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import selenium.ClsReport;
import selenium.ClsWebElements;
import selenium.ExcelReport;

/**
 * 
 * @author paul
 *
 */
public class LightningOffers extends ClsWebElements {
	
	//Constant
	int NumPage =0; //Page's number
	
	By PromotionsBtn = By.linkText("Promociones"); //Promotion button
	By LightningOffersBtn = By.xpath("//span[text() = 'Oferta relámpago']");
	By ListOfferItems = By.xpath("//div[@class = 'DealContent-module__truncate_sWbxETx42ZPStTc9jwySW']");
	By IndexPage = By.xpath("//li[@class = 'a-disabled'][3]");
	By NextBtn = By.xpath("//li[@class = 'a-last']");
	
	/**
	 * 
	 * @throws InterruptedException
	 */
	//This method is for go to promotion section and apply Lightning Deals filter
	public void showLightningOffers() throws InterruptedException{
		Click(PromotionsBtn);
		WaitForLoad();
		ClsReport.fnLog(Status.PASS, "Step - Go to Promotions.", false);
		Scroll(LightningOffersBtn);
		ClsReport.fnLog(Status.PASS, "Step - Search Lightning Deals filter.", false);
		Click(LightningOffersBtn);
		WaitForLoad();
		ClsReport.fnLog(Status.PASS, "Step - Apply filter.", false);
		Thread.sleep(5000);
	}
	
	//This method is for get all product's name of Lightning Deals section, first get the number of pages there are, 
	//we use this to know how many pages we need to get the products from.
	public void GetListItems() throws Exception{
		Scroll(IndexPage); //show the number of pages there are
		ClsReport.fnLog(Status.PASS, "Step - Search number of pages.", false);
		WebElement objText = GetWebElement(IndexPage);
		String NumberText = objText.getAttribute("innerText");
		ClsReport.fnLog(Status.PASS, "Step - Get number of pages and save in a String.", false);
		int index = Integer.parseInt(NumberText);
		ClsReport.fnLog(Status.PASS, "Step - Convert number of page to number.", false);
		System.out.println(getWebList(ListOfferItems));
		
		for(int i = 0; i<index; i++) {
			Thread.sleep(3000); //wait for products load
			ClsReport.fnLog(Status.PASS, "Step - Get all product of the page.", false);
			NumPage = i +1;// know what page we are
			ClsReport.fnLog(Status.INFO, "Page No. " + NumPage , false);
			ClsReport.fnLog(Status.PASS, "Step - Show products name.", false);
			ForEachList(ListOfferItems, "innerText");//call the method to obtain the product names
			if(i==index-1) {
				System.out.println("last page"); //know that we are in the last page
				ExcelReport.EndReport(); // create excel file
			}else {
				Scroll(NextBtn);
				Click(NextBtn); //go to next page
				ClsReport.fnLog(Status.PASS, "Step - Go to next page.", false);
			}
			
		}
		
	}
}
