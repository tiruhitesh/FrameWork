package com.Automation.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory 
{
	public static WebDriver StartApplication(WebDriver driver,String browserName,String appURL)
	{
		if(browserName.equals("chrome"))
		{
			System.setProperty("weddriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("weddriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		}
		else
		{
			System.out.println("Browser not supporting");
		}
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
    public static  void quitBrowser(WebDriver driver)
    {
    	driver.quit();
    }
}
