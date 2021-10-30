package com.qa.util;

import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.qa.base.TestBase;

public class TestListener extends TestBase implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
	    String methodName = result.getMethod().getMethodName();
	    TestBase.takeScreenshot(methodName);
	    
	    
	  }

}
