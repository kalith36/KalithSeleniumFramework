package com.qa.runner;

import org.testng.annotations.BeforeTest;

import com.qa.util.TestUtil;

import cucumber.api.CucumberOptions;

@CucumberOptions(
		features="src/test/java/com/qa/features/login.feature",
		glue= {"com.qa.steps"},
		monochrome=true,
		dryRun= false
		)

public class RunnerTest extends TestUtil {

@BeforeTest
public void set() {
	excelfileName="file";
}
}
