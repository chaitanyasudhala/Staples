package com.staples.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.staples.pageObjects.LoginPage;

public class TC_LoginTestCase extends BaseClass {

	LoginPage lp;

	@Test
	public void loginTest() throws InterruptedException {

		lp = new LoginPage(driver);
		logger.info("URL succesfully opened");

		lp.setUserName(userName);
		logger.info("Entered User Name");

		lp.setPassword(password);
		logger.info("Entered password");

		lp.clickOnSignIn();
		logger.info("SignIn button clicked");
		Thread.sleep(3000);

	}

	@Test
	public void loginPageValidation() {

		boolean flag = lp.validateAccountMenu();
		Assert.assertTrue(flag);
	}

	/*
	 * public void loginPageValidation() {
	 * 
	 * String pageTitle = lp.getPageTitle(); System.out.println(pageTitle);
	 * 
	 * 
	 * 
	 * }
	 */

}
