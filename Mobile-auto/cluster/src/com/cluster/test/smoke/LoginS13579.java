package com.cluster.test.smoke;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cluster.repo.ui.object.HomePage;
import com.cluster.repo.ui.object.MenuOptionsPage;
import com.cluster.repo.ui.object.SignInPage;
import com.cluster.test.config.Configuration;
import com.cluster.test.config.CreateDriver;
import com.cluster.utils.DataHandlers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class LoginS13579 extends Configuration
{
	AppiumDriver driver;
	AppiumDriverLocalService service;
	HomePage homePage;
	MenuOptionsPage menuOptions;
	SignInPage signIn;
	
	@BeforeMethod
	public void setUp()
	{
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		driver = CreateDriver.getDriverInstance();
		homePage = new HomePage(driver);
		menuOptions = new MenuOptionsPage(driver);
		signIn = new SignInPage(driver);
	}

	@Test
	public void loginTC155()
	{
		String emailID = DataHandlers.getDataFromExcel("data", "TC155", 1, 0);
		String password = DataHandlers.getDataFromExcel("data", "TC155", 1, 1);
		// Got to home page and click on MenuIcon
		homePage.getMenuIcon().click();
		// Choose My Accounts
		menuOptions.getMyAccountOption().click();
		
		// Enter Email ID
		signIn.getEmailTextbox().click();
		signIn.getCancelButtonOnPopUp().click();
		signIn.getEmailTextbox().sendKeys(emailID);
		// Enter password
		signIn.getpasswordTextbox().sendKeys(password);
		
		// Click on SignIn button
		signIn.getSignInButton().click();
		
		// Get error Msg
		String actualErrorMsg = signIn.getErrorMessage().getText();
		String expectedErrorMsg = "Invalid login details";
		AssertJUnit.assertEquals(actualErrorMsg, expectedErrorMsg);
	}
	@AfterMethod
	public void tearDown()
	{
		service.stop();
	}
}
