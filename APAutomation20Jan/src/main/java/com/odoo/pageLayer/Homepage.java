package com.odoo.pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[text()='Sign in'])[1]")
	private WebElement signin_link;
	
	@FindBy(xpath = "(//*[text()='Shop'])[1]")
	private WebElement shop_link;
	
	public void clickOnSignInLink()
	{
		signin_link.click();
	}
	
	public void clickOnShopLink()
	{
		shop_link.click();
	}
}
