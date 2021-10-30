package com.qa.util;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.base.TestBase;

public abstract class Reporter extends TestBase{

	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test, node;

	public String testcaseName, testcaseDec, author, category;
	public String excelFileName;

	@BeforeSuite
	public void startReport() {
		reporter = new ExtentHtmlReporter("./reports/result.html");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeClass
	public void report() throws IOException {
		test = extent.createTest(testcaseName, testcaseDec);
		test.assignAuthor(author);
		test.assignCategory(category);  
	}

	public abstract long takeSnap();
	public void reportStep(String dec, String status,boolean bSnap ) {
		MediaEntityModelProvider img = null;
		if(bSnap && !status.equalsIgnoreCase("INFO")){

			long snapNumber = 100000L;
			snapNumber = takeSnap();
			try {
				img = MediaEntityBuilder.createScreenCaptureFromPath
						("./../reports/images/"+snapNumber+".jpg").build();
			} catch (IOException e) {

			}
		}
		if(status.equalsIgnoreCase("pass")) {
			node.pass(dec, img);
		} else if(status.equalsIgnoreCase("fail")) {
			node.fail(dec, img); 
		}
	}

	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}


	@AfterSuite
	public void stopReport() {
		extent.flush();
	}
}



