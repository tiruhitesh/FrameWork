package com.Automation.Pages;
import java.io.File;
import java.io.IOException;

// https://www.youtube.com/watch?v=RvwMu7tG6TA&list=PL6flErFppaj0WwNOMFeXPVlNCDuJyPYFi&index=5
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.Automation.TestCases.CofigDataProvider;
import com.Automation.Utility.BrowserFactory;
import com.Automation.Utility.ExcelDataProvider;
import com.Automation.Utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
// https://www.youtube.com/watch?v=bcMPotY18Uo&list=PL6flErFppaj0WwNOMFeXPVlNCDuJyPYFi&index=6
public class BaseClass 
    {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public CofigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	@BeforeSuite
	public void setUpSuite()
	{
		 Reporter.log("Setting reports and test getting ready", true);
		 excel = new ExcelDataProvider();
		 config = new CofigDataProvider();
		 ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./Reports/FreeCRM+Helper"+Helper.getCurrentDateTime()+".html"));
		 report = new ExtentReports();
		 report.attachReporter(extent);
		 Reporter.log("Setting Done test can be  started", true);
	}
	
	@BeforeClass
	public void setUp()
	{
	driver =  BrowserFactory.StartApplication(driver, config.getBrowserFromConfig(),config.getURLFromConfig());
	}
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	@AfterMethod
	public void tearDownMthode(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.FAILURE) 
		{
			
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		 else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());

		}else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("Test skip", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());

		}
		Reporter.log("<---- Reports Generated ---->", true);
		report.flush();
	}

}
