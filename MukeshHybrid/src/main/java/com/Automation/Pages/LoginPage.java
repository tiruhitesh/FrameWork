package com.Automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
   {
	WebDriver driver;
  public LoginPage(WebDriver ldriver)
  {
	this.driver=ldriver;  
  }
  @FindBy(name="email") WebElement uname;
  @FindBy(name="password") WebElement pass;
  @FindBy(xpath="//div[@class='ui fluid large blue submit button']") WebElement loginbtn;
  
  public void loginToCRM(String usernameApplication,String passwordApplication)
  {
	  uname.sendKeys(usernameApplication);
	  pass.sendKeys(passwordApplication);
	  loginbtn.click();
  }
}
 
