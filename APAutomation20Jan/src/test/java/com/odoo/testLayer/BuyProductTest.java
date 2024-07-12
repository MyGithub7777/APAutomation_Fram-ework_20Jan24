package com.odoo.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.odoo.pageLayer.Cartpage;
import com.odoo.pageLayer.Checkoutpage;
import com.odoo.pageLayer.Homepage;
import com.odoo.pageLayer.Loginpage;
import com.odoo.pageLayer.Paymentpage;
import com.odoo.pageLayer.Shoppage;
import com.odoo.testBase.Testbase;



public class BuyProductTest extends Testbase {

	@Test
	public void verifyBuyProductTest() throws InterruptedException
	{
		String expected_result = "Your payment has been successfully processed.";
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		Shoppage shoppage_obj = new Shoppage(driver);
		Cartpage cartpage_obj = new Cartpage(driver);
		Checkoutpage checkoutpage_obj = new Checkoutpage(driver);
		Paymentpage paymentpage_obj = new Paymentpage(driver);
		
		homepage_obj.clickOnSignInLink();
		loginpage_obj.enterEmailAddress("mohitgupta1@gmail.com");
		loginpage_obj.enterPassword("Test@1234");
		loginpage_obj.clickOnLoginButton();
		
		homepage_obj.clickOnShopLink();
		shoppage_obj.clickOnHPLaptopLink();
		shoppage_obj.clickOnAddTocartbutton();
		Thread.sleep(2000);
		shoppage_obj.clickOnMycartlink();
		
		cartpage_obj.clickOnCheckoutButton();
		Thread.sleep(2000);
		checkoutpage_obj.fillExtraInfo("Mohit", "This is good product", "C:\\Users\\232338\\Downloads\\3 Cucumber Advanced.pdf");
		checkoutpage_obj.clickOnCheckoutButton();
		paymentpage_obj.enterCardDetails("4111222233334444");
		paymentpage_obj.clickOnPayButton();
		
		Thread.sleep(8000);
		String actual_result = paymentpage_obj.getStatusMessage();
		Assert.assertEquals(actual_result, expected_result);
		
	}
}
