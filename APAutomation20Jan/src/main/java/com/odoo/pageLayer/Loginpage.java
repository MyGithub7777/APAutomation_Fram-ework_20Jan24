package com.odoo.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {


	private WebDriver driver;
	public Loginpage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//------------ Obj repo ------------
	
	private By email_textbox = By.xpath("//input[@id='login']");
	private By password_textbox = By.xpath("//input[@id='password']");
	private By login_btn = By.xpath("//button[contains(text(),'Log in')]");
	
	private By donthaveaccount_link = By.xpath("//a[contains(text(),\"Don't have an account?\")]");
	private By error_message = By.xpath("//p[@class='alert alert-danger']");
	
	//------------ Action Methods ------
	
	public void clickOnDontHaveAccountLink()
	{
		driver.findElement(donthaveaccount_link).click();
	}
	
	public String getErrorMessage()
	{
		 String text = driver.findElement(error_message).getText();
		 return text;
	}
	
	public void enterEmailAddress(String email)
	{
		driver.findElement(email_textbox).sendKeys(email); 
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(password_textbox).sendKeys(password);
	}
	
	public void clickOnLoginButton()
	{
		driver.findElement(login_btn).click();;
	}
	
}
