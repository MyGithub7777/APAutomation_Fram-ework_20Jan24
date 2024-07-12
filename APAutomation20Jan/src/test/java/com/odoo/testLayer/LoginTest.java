package com.odoo.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.odoo.pageLayer.Homepage;
import com.odoo.pageLayer.Loginpage;
import com.odoo.testBase.Testbase;

public class LoginTest extends Testbase {
	
	@Test
	public void verifyLoginTestWithValidDetails()
	{
		String expected_result = "My Portal | testing";
		
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		
		homepage_obj.clickOnSignInLink();
		loginpage_obj.enterEmailAddress("mohitgupta1@gmail.com");
		loginpage_obj.enterPassword("Test@1234");
		loginpage_obj.clickOnLoginButton();
		
		String actual_result = driver.getTitle();
		System.out.println(actual_result);
		
		Assert.assertEquals(actual_result, expected_result); 
		
	}
	
	@Test
	public void verifyLoginTestWithInValidDetails()
	{
		String expected_result = "Wrong login/password";
		
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		
		homepage_obj.clickOnSignInLink();
		loginpage_obj.enterEmailAddress("mohitgupta1@gmail.com");
		loginpage_obj.enterPassword("Test");
		loginpage_obj.clickOnLoginButton();
		
		String actual_result = loginpage_obj.getErrorMessage();
		System.out.println(actual_result);
		
		Assert.assertEquals(actual_result, expected_result); 
	}
}
