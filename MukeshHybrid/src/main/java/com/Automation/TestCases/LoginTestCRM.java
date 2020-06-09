package com.Automation.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Automation.Pages.BaseClass;
import com.Automation.Pages.LoginPage;
import com.Automation.Utility.BrowserFactory;
import com.Automation.Utility.ExcelDataProvider;
import com.Automation.Utility.Helper;

public class LoginTestCRM extends BaseClass
   {  
	
	
  @Test
  public void loginApp()
  
  {
	  ExcelDataProvider excel = new ExcelDataProvider();
	  logger= report.createTest("Lofin to CRM");
	  System.out.println("title   >"+driver.getTitle());
	  System.out.println("<------Test started------>");
		LoginPage loginpage=PageFactory.initElements(driver	, LoginPage.class);
		logger.info("Application started");
		loginpage.loginToCRM(excel.getStringData("Sheet1", 0, 0),excel.getStringData("Sheet1", 0, 1));
		logger.pass("Test Sucess");
		System.out.println("<------Test Completed------>");
  }
   }
	
	
	
  

