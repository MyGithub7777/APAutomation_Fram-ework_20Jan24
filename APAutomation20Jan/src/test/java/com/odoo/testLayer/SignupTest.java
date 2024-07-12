package com.odoo.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.odoo.pageLayer.Homepage;
import com.odoo.pageLayer.Loginpage;
import com.odoo.pageLayer.MyAccountpage;
import com.odoo.pageLayer.Signuppage;
import com.odoo.testBase.Testbase;

public class SignupTest extends Testbase {

	@Test
	public void verifySignupTestWithValidDetails()
	{
		String expected_result = "mohit2";
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		Signuppage signuppage_obj = new Signuppage(driver);
		MyAccountpage myaccountpage_obj = new MyAccountpage(driver);
		
		homepage_obj.clickOnSignInLink();
		loginpage_obj.clickOnDontHaveAccountLink();
		signuppage_obj.enterEmailAddress("mohitgupta3@gmail.com");
		signuppage_obj.enterUsername("mohit3");
		signuppage_obj.enterPassword("Test@1234");
		signuppage_obj.enterConfirmPassword("Test@1234");
		signuppage_obj.clickOnSignupButton();
		
		String actual_result = myaccountpage_obj.getUsernameFromAccountPage();
		System.out.println("The username text is :- "+actual_result);
		
		Assert.assertEquals(actual_result, expected_result);
	}
	
	@Test
	public void verifySignupTestWithAlreadyRegisteredEmailID()
	{
		String expected_result = "Another user is already registered using this email address.";
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		Signuppage signuppage_obj = new Signuppage(driver);
		
		homepage_obj.clickOnSignInLink();
		loginpage_obj.clickOnDontHaveAccountLink();
		signuppage_obj.enterEmailAddress("mohitgupta2@gmail.com");
		signuppage_obj.enterUsername("mohit2");
		signuppage_obj.enterPassword("Test@1234");
		signuppage_obj.enterConfirmPassword("Test@1234");
		signuppage_obj.clickOnSignupButton();
		
		String actual_result = loginpage_obj.getErrorMessage();
		System.out.println("The error text is :- "+actual_result);
		
		Assert.assertEquals(actual_result, expected_result);
	}
	
	@Test
	public void verifySignupTestWithMissMatchPassword()
	{
		String expected_result = "Passwords do not match; please retype them.";
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		Signuppage signuppage_obj = new Signuppage(driver);
		
		homepage_obj.clickOnSignInLink();
		loginpage_obj.clickOnDontHaveAccountLink();
		signuppage_obj.enterEmailAddress("mohitgupta2@gmail.com");
		signuppage_obj.enterUsername("mohit2");
		signuppage_obj.enterPassword("Test@1234");
		signuppage_obj.enterConfirmPassword("Test");
		signuppage_obj.clickOnSignupButton();
		
		String actual_result = loginpage_obj.getErrorMessage();
		System.out.println("The error text is :- "+actual_result);
		
		Assert.assertEquals(actual_result, expected_result);
	}
}
