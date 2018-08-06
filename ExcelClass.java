package BugSquashersPLP;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelClass {

	public static void main(String[] args) throws IOException, NumberFormatException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:/PLP/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream(new File("D:/Book1.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook (fis);
		XSSFSheet sheet = workbook.getSheetAt(1);
		int rowCount=sheet.getLastRowNum()+1;
 		ExcelMethods ex=new ExcelMethods();
 		
 		for(int i=0;i<rowCount;i++)
 		{
 			String keyword = String.valueOf(sheet.getRow(i).getCell(2).getStringCellValue());
 			String type = String.valueOf(sheet.getRow(i).getCell(3).getStringCellValue());
 			String value = String.valueOf(sheet.getRow(i).getCell(4).getStringCellValue());
 			String param= String.valueOf(sheet.getRow(i).getCell(5).getStringCellValue());
 			switch(keyword)
 			{ 			
 			case "Navigate": 		ex.navigate(driver,param);
 									break;
 									
 			case "click_element":	ex.clickElement(driver,type,value);
 									break;
 									
 			case "clear_text":		ex.clear(driver,type,value);
 									break;
 									
 			case "send_keys":		ex.sendKeys(driver,type,value,param);
 									break;
									
 			case "select_element": String type1 = String.valueOf(sheet.getRow(++i).getCell(3).getStringCellValue());
 										param = String.valueOf(sheet.getRow(i).getCell(5).getStringCellValue());
 										ex.selectElement(driver,type,type1,value,param);
 										break;
 			case "sleep": Thread.sleep(Integer.parseInt(param));break;
 			case "quit" :driver.quit();break;
 			}
 		}
       fis.close();
	}
}