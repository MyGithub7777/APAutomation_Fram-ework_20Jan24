package com.odoo.testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Testbase {

	public static WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		String browsername = "chrome";
		
		if(browsername == "chrome")
		{
			driver = new ChromeDriver();
		}
		else if(browsername == "firefox")
		{
			driver = new FirefoxDriver();
		}
		else if (browsername == "edge")
		{
			driver = new EdgeDriver();
		}
		else 
		{
			System.out.println("Nothing to launch please ocrrect details");
		}
		
		driver.get("https://ap-automation.odoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
