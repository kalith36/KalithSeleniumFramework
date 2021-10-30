package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.util.TestUtil;
import com.qa.util.WebEventListener;

import cucumber.api.testng.AbstractTestNGCucumberTests;

public class TestBase extends AbstractTestNGCucumberTests{
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test, node;

	public static WebDriver driver;
	public static Properties prop;
	public static Object[][] data ;
	public static String excelfileName,testcaseName, testcaseDec, author, category;
	public static EventFiringWebDriver eventDriver;
	public static WebEventListener eventListener;
	
	public static XSSFWorkbook wbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public TestBase() {

		try {
			prop=new Properties();
			FileInputStream file = new FileInputStream("D:\\eclipse\\FrameworkKalith\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	


	}

	public static void initialization() {

		String browser=prop.getProperty("browser");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./chromedriver_new.exe");
			driver=new ChromeDriver();
		}else if(browser.equals("gecko")){
			System.setProperty("webdriver.chrome.driver", "./chromedriver_new.exe");
			driver=new FirefoxDriver();
		}
		
		
		//Create Onject of EventFiringWebDriver Class and pass the constructor for webdriver instance which is driver
		eventDriver=new EventFiringWebDriver(driver);
		//Create object of our web event listener class
		eventListener = new WebEventListener();
		//Register our object with eventDriver instance
		eventDriver.register(eventListener);
		//Give the value/assign from eventDriver to our driver(Webdriver)
		driver=eventDriver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

	public static void frameWithIndex(int index) {
		driver.switchTo().frame(index);
	}

	public static void frameWithName(String name ) {
		driver.switchTo().frame(name);
	}

	public static void frameWithWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public static void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public static void getTextFromAlert() {
		driver.switchTo().alert().getText();
	}

	public static void sendMSGToAlert(String message) {
		driver.switchTo().alert().sendKeys(message);
	}

	public void selectDropDownUsingText(WebElement ele, String value) {

		new Select(ele)
		.selectByVisibleText(value);
	}


	public void selectDropDownUsingIndex(WebElement ele, int index) {
		new Select(ele)
		.selectByIndex(index);
	}


	public void selectDropDownUsingValue(WebElement ele, String value) {
		new Select(ele)
		.selectByValue(value);
	}
	
	public static void takeScreenshot(String methodName)  {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String currentDir=System.getProperty("user.dir");
			File desc=new File(currentDir+"/Screenshot/"+methodName+".png");
			FileUtils.copyFile(src, desc);
		} catch (WebDriverException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}








}