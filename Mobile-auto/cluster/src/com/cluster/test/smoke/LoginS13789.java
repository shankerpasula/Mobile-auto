package com.cluster.test.smoke;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cluster.repo.ui.object.HomePage;
import com.cluster.repo.ui.object.MenuOptionsPage;
import com.cluster.repo.ui.object.SignInPage;
import com.cluster.test.config.Configuration;
import com.cluster.test.config.CreateDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class LoginS13789 extends Configuration
{
	AppiumDriver driver;
	AppiumDriverLocalService service;
	HomePage homePage;
	MenuOptionsPage menuOptions;
	SignInPage signInPage;
	
	@BeforeMethod
	public void setUp()
	{
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		driver = CreateDriver.getDriverInstance();
		homePage = new HomePage(driver);
		menuOptions = new MenuOptionsPage(driver);
		signInPage = new SignInPage(driver);
	}
	@Test
	public void testTC182()
	{
		homePage.getMenuIcon().click();
		menuOptions.getMyAccountOption().click();
		signInPage.getSignInButton().click();
		String actualErrorMsg = signInPage.getErrorMessage().getText();
		String expectedErrorMsg = "Please enter valid Email ID/Mobile Number";
		AssertJUnit.assertEquals(actualErrorMsg, expectedErrorMsg);
	}
	@AfterMethod
	
	public void tearDown()
	{
//		service.stop();
	}
}
