package com.cluster.repo.ui.object;

import org.openqa.selenium.WebElement;

import com.cluster.repo.ui.aos.SignIN;

import io.appium.java_client.AppiumDriver;

public class SignInPage 
{
	AppiumDriver driver;
	String instanceName;
	public SignInPage(AppiumDriver driver)
	{
		this.driver = driver;
		instanceName = driver.getClass().getName();
	}
	public WebElement getEmailTextbox()
	{
		if(instanceName.contains("Android"))
		{
			return driver.findElement(SignIN.email);
		}
		else
		{
			return driver.findElement(com.cluster.repo.ui.ios.SignIN.email);
		}
	}
	public WebElement getpasswordTextbox()
	{
		if(instanceName.contains("Android"))
		{
			return driver.findElement(SignIN.password);
		}
		else
		{
			return driver.findElement(com.cluster.repo.ui.ios.SignIN.password);
		}
	}
	public WebElement getCancelButtonOnPopUp()
	{
		if(instanceName.contains("Android"))
		{
			return driver.findElement(SignIN.emailTextboxPoupMenuCancel);
		}
		else
		{
			return driver.findElement(com.cluster.repo.ui.ios.SignIN.emailTextboxPoupMenuCancel);
		}
	}
	public WebElement getSignInButton()
	{
		if(instanceName.contains("Android"))
		{
			return driver.findElement(SignIN.signIn);
		}
		else
		{
			return driver.findElement(com.cluster.repo.ui.ios.SignIN.signIn);
		}
	}
	public WebElement getErrorMessage()
	{
		if(instanceName.contains("Android"))
		{
			return driver.findElement(SignIN.errorMsg);
		}
		else
		{
			return driver.findElement(com.cluster.repo.ui.ios.SignIN.errorMsg);
		}
	}
}
