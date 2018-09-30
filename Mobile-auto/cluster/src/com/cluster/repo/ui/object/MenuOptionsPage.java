package com.cluster.repo.ui.object;

import org.openqa.selenium.WebElement;

import com.cluster.repo.ui.aos.MenuOptions;

import io.appium.java_client.AppiumDriver;

public class MenuOptionsPage 
{
	AppiumDriver driver;
	String instanceName;
	public MenuOptionsPage(AppiumDriver driver)
	{
		this.driver = driver;
		instanceName = driver.getClass().getName();
	}
	public WebElement getMyAccountOption()
	{
		if(instanceName.contains("Android"))
		{
			return driver.findElement(MenuOptions.myAccount);
		}
		else
		{
			return driver.findElement(com.cluster.repo.ui.ios.MenuOptions.myAccount);
		}
	}
	public WebElement getMyOrdersOption()
	{
		if(instanceName.contains("Android"))
		{
			return driver.findElement(MenuOptions.myOrders);
		}
		else
		{
			return driver.findElement(com.cluster.repo.ui.ios.MenuOptions.myOrders);
		}
	}
}
