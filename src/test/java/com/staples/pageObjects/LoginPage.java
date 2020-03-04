package com.staples.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	// Initilaizing PageFactory usinng default constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// Storing UserName Locator in WebElement
	@FindBy(name = "username")
	WebElement username_locator;

	// Storing Password Locator in WebElement
	@FindBy(name = "password")
	WebElement password_locator;

	// Storing Signin button locator in WebElement
	@FindBy(id = "loginSubmit")
	WebElement signin_locator;
	
	//Storing Account Menu locator to validate Login
	@FindBy(xpath = "//div[@aria-label,'AccountMenuFlyout']")
	WebElement accountMenu_locator;

	public void setUserName(String Uname) {
		username_locator.sendKeys(Uname);
	}

	public void setPassword(String pwd) {
		password_locator.sendKeys(pwd);
	}

	public void clickOnSignIn() {
		signin_locator.click();
	}
	
	public boolean validateAccountMenu() {
		return accountMenu_locator.isDisplayed();
	}

	/*
	 * public String getPageTitle() {
	 * 
	 * String title = driver.getTitle(); return title; }
	 */
}