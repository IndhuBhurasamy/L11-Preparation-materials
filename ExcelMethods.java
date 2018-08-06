package BugSquashersPLP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class ExcelMethods {
	
	void navigate(WebDriver driver,String url)
	{
		driver.get(url);
	}
	
	void clickElement(WebDriver driver,String type,String value)
	{
		switch(type)
		{
			case "id": driver.findElement(By.id(value)).click();break;
			case "xpath": driver.findElement(By.xpath(value)).click();break;
			case "name": driver.findElement(By.name(value)).click();break;
		}
	}
	void clear(WebDriver driver,String type,String value)
	{
		switch(type)
		{
			case "id": driver.findElement(By.id(value)).clear();break;
			case "xpath": driver.findElement(By.xpath(value)).clear();break;
			case "name": driver.findElement(By.name(value)).clear();break;
		}
	}
	void sendKeys(WebDriver driver,String type,String value,String param)
	{
		switch(type)
		{
			case "id": driver.findElement(By.id(value)).sendKeys(param);break;
			case "xpath": driver.findElement(By.xpath(value)).sendKeys(param);break;
			case "name": driver.findElement(By.name(value)).sendKeys(param);break;
		}
	}
	
	void selectElement(WebDriver driver,String type,String type1,String value,String param)
	{
		Select from;
		switch(type)
		{
			case "id": from=new Select(driver.findElement(By.id(value)));
			switch(type1)
			{
				case "Value": from.selectByValue(param);break;
				case "VisibleText": from.selectByVisibleText(param);break;
				case "Index": from.selectByIndex(Integer.parseInt(param));break;
			}break;
			case "xpath": from=new Select(driver.findElement(By.xpath(value)));
			switch(type1)
			{
				case "Value": from.selectByValue(param);break;
				case "VisibleText": from.selectByVisibleText(param);break;
				case "Index": from.selectByIndex(Integer.parseInt(param));break;
			}break;
			case "name": from=new Select(driver.findElement(By.name(value)));
			switch(type1)
			{
				case "Value": from.selectByValue(param);break;
				case "VisibleText": from.selectByVisibleText(param);break;
				case "Index": from.selectByIndex(Integer.parseInt(param));break;
			}break;
		}
		
	}
}
