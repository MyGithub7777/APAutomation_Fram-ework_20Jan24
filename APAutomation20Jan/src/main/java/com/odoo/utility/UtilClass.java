package com.odoo.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.odoo.testBase.Testbase;

public class UtilClass extends Testbase {

	public static void takeScreenshotOfPage(String filename)
	{
		String path = "D:\\Workspace\\04May-EW\\APAutomation20Jan\\screenshots\\";
		try 
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			File des = new File(path+filename+".png");
			FileHandler.copy(src, des);
		} 
		catch (IOException e) {
			System.out.println("Please provide proper path");
		}
	}
}
