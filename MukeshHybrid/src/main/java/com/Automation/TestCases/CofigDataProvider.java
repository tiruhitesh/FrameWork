package com.Automation.TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CofigDataProvider 
  {
	Properties pro;
	public CofigDataProvider()
	{
		File src=new File("./Config/Config.properties");
		try {
		FileInputStream fis=new FileInputStream(src);
		pro = new Properties();
		
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Not albe to load file"+e.getMessage());
		}
		
	}
	public String getDataFromConfig(String KeySearch)
	{
		return pro.getProperty(KeySearch);
	}
	public String getBrowserFromConfig()
	{
		return pro.getProperty("Browser");
	}
	public String getURLFromConfig()
	{
		return pro.getProperty("qaURL");
	}
}
