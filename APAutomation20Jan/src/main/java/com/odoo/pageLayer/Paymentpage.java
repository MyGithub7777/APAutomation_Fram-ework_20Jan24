package com.odoo.pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Paymentpage {
	
	public Paymentpage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//====================== obj repo=========
	@FindBy(xpath="//input[@id='customer_input']")
	private WebElement payment_detail_txtbox;
	
	@FindBy(xpath="//button[contains(text(),'Pay now')]")
	private WebElement pay_button;
	
	@FindBy(xpath="//span/p")
	private WebElement status_msg;
	

	//================action methods=================
	public void enterCardDetails (String card_number)
	{
		payment_detail_txtbox.sendKeys(card_number);
	}
	
	public void clickOnPayButton()
	{
		pay_button.click();
	}
	
	public String getStatusMessage()
	{
		String msg = status_msg.getText();
		return msg;
	}
}
