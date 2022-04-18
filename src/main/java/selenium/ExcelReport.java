package selenium;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author paul
 *
 */
//This class is for make a excel to show all Product's name
public class ExcelReport {
	// First we initialize the name of our excel workbook, we create and name a sheet
	private static XSSFWorkbook ProductsReport = new XSSFWorkbook();
	private static XSSFSheet LightningDeals = ProductsReport.createSheet("Lightning Deals");
	
//Here create a row in "Lightning Deals" sheet and create 2 columns, "No." column and "Product Name" column
	public static void StartExcelReport() {
		
		LightningDeals.createRow(0);
		LightningDeals.getRow(0).createCell(0).setCellValue("No.");
		LightningDeals.getRow(0).createCell(1).setCellValue("Product Name");
	}
	
	/**
	 * 
	 * @param index
	 * @param e
	 */
	//Add the number and name of each product in columns
	public static void AddNewItem(int index, WebElement e) {
		LightningDeals.createRow(index);
		LightningDeals.getRow(index).createCell(0).setCellValue(index);
		LightningDeals.getRow(index).createCell(1).setCellValue(e.getAttribute("innerText"));
	}
	
	//Here create ProductsReport.xlsx and write inside each Product's name
	public static void EndReport() throws Exception {
		File file = new File("C:\\Users\\paule\\OneDrive\\Escritorio\\ProductsReport.xlsx");
		FileOutputStream fos =new FileOutputStream(file);
		ProductsReport.write(fos);
		ProductsReport.close();
	
	}
}
