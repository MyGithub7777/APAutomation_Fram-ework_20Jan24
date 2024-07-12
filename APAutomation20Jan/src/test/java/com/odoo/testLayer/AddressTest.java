package com.odoo.testLayer;

import org.testng.annotations.Test;

import com.odoo.pageLayer.Addresspage;
import com.odoo.pageLayer.Homepage;
import com.odoo.pageLayer.Loginpage;
import com.odoo.pageLayer.MyAccountpage;
import com.odoo.testBase.Testbase;

public class AddressTest extends Testbase {

	@Test
	public void addNewAddress() throws InterruptedException
	{
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		MyAccountpage myaccountpage_obj = new MyAccountpage(driver);
		Addresspage addresspage_obj = new Addresspage(driver);
		
		homepage_obj.clickOnSignInLink();
		loginpage_obj.enterEmailAddress("mohitgupta1@gmail.com");
		loginpage_obj.enterPassword("Test@1234");
		loginpage_obj.clickOnLoginButton();
		myaccountpage_obj.clickOnAddressesLink();
		
		addresspage_obj.fillAllAddressDetails("mohit1", "mohitgupta1@gmail.com", "wipro", "564654655", "abcd line, street 123", "pune", "413521", "India", "Maharashtra");
		Thread.sleep(3000);
		addresspage_obj.clickOnSaveButton();
	}
}
