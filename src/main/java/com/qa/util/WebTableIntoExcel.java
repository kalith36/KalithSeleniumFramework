package com.qa.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableIntoExcel {
	
	@Test
	public void webTable() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./chromedriver_new.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Enter the URL
		driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population");
		
		String path="./data/sample.xlsx";
		XLUtility xl=new XLUtility(path);
		
		/*xl.writeExcelData("sheet1", 0, 0, "Country");
		xl.writeExcelData("sheet1", 0, 1, "Region");
		xl.writeExcelData("sheet1", 0, 2, "Population");
		xl.writeExcelData("sheet1", 0, 3, "% of World");
		xl.writeExcelData("sheet1", 0, 4, "date");
		xl.writeExcelData("sheet1", 0, 5, "Source");*/
		
		
		WebElement table = driver.findElement(By.xpath("//table[contains(@class,'wikitable sortable jquery-tablesorter')]/tbody"));
		int rows = table.findElements(By.xpath("tr")).size();
		int cols=table.findElements(By.xpath("tr[1]/td")).size();
		System.out.println("Row count"+rows);
		System.out.println("Column count"+cols);
	
		
			
				for (int i = 2; i < 10; i++) {
					for (int j = 1; j < cols-1; j++) {
						
					
					
					//Read data from webTable
					String data = table.findElement(By.xpath("tr["+i+"]/td["+j+"]")).getText();
					
					/*String country=table.findElement(By.xpath("tr["+i+"]/td[1]")).getText();
					String region=table.findElement(By.xpath("tr["+i+"]/td[2]")).getText();
					String population=table.findElement(By.xpath("tr["+i+"]/td[3]")).getText();
					String percent=table.findElement(By.xpath("tr["+i+"]/td[4]")).getText();
					String date=table.findElement(By.xpath("tr["+i+"]/td[5]")).getText();
					String source=table.findElement(By.xpath("tr["+i+"]/td[6]")).getText();
					System.out.println(country+region+population+percent+date+source);*/
					
					
					//Write data into excel
					xl.writeExcelData("sheet1", i-1, j-1, data);
					
					/*xl.writeExcelData("sheet1", i-1, 0, country);
					xl.writeExcelData("sheet1", i-1, 1, region);
					xl.writeExcelData("sheet1", i-1, 2, population);
					xl.writeExcelData("sheet1", i-1, 3, percent);
					xl.writeExcelData("sheet1", i-1, 4, date);
					xl.writeExcelData("sheet1", i-1, 5, source);*/
					
					}
				}
				
			
			
		
		
		
		
		
		driver.close();

	}

}
