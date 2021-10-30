package com.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import com.qa.base.TestBase;

import cucumber.api.testng.AbstractTestNGCucumberTests;



public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPLICITLY_WAIT =10;
	
	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return XLUtility.readExcelData(excelfileName);
	}
	
	/*public static void takeScreenshot()  {
		try {
			long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String currentDir=System.getProperty("user.dir");
			File desc=new File(currentDir+"/Screenshot/"+number+".png");
			FileUtils.copyFile(src, desc);
		} catch (WebDriverException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}*/
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	

}


