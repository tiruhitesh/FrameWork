package com.Automation.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestCaseWithOutFrameWork 
{
    @Test
	public void test1()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://ui.freecrm.com/");
		System.out.println("<-----Test Started------>");
		System.out.println("Title of the page "+driver.getTitle());
		
		driver.findElement(By.name("email")).sendKeys("Selenium_50");
		driver.findElement(By.name("password")).sendKeys("Abcd@123456");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div/div[3]")).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("<-----Test Completerd------>");
		driver.quit();
		
	}
}
