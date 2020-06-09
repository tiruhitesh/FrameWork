package com.Automation.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
    {
	XSSFWorkbook wb;
	
	public ExcelDataProvider() 
	{
		File src = new File("./TestData/TestData.xlsx");
		try {
			FileInputStream fis= new FileInputStream(src);
			 wb=new XSSFWorkbook(fis);
		
		} catch (Exception e) {
		
			System.out.println("Unable to read to excelfile"+e.getMessage());
		}
	}
	public String getStringData(int sheetIndex,int row,int colum)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(colum).getStringCellValue();
	}
	
	public String getStringData(String sheetName,int row,int colum)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(colum).getStringCellValue();
	}
	public double getNumaricData(String sheetName,int row,int colum)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(colum).getNumericCellValue();
	}
		
		
		
	
	

}
