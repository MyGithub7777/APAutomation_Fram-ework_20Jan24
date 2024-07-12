package com.odoo.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountpage {
	
	private WebDriver driver;
	public MyAccountpage(WebDriver d)
	{
		driver = d;
	}
	
	//------------ Obj repo ------------
	
	private By username_text = By.xpath("//h5[@class='mb-0']");
	private By addresses_link = By.xpath("//span[text()='Addresses']");
	
	public String getUsernameFromAccountPage()
	{
		String text = driver.findElement(username_text).getText();
		return text;
	}
	
	public void clickOnAddressesLink()
	{
		driver.findElement(addresses_link).click();
	}
}
