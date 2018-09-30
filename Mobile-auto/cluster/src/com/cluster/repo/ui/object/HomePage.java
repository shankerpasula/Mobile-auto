package com.cluster.repo.ui.object;

import org.openqa.selenium.WebElement;

import com.cluster.repo.ui.aos.Home;

import io.appium.java_client.AppiumDriver;

public class HomePage 
{
	AppiumDriver driver;
	String instanceName;
	public HomePage(AppiumDriver driver)
	{
		this.driver = driver;
		instanceName = driver.getClass().getName();
	}
	public WebElement getMenuIcon()
	{
		if(instanceName.contains("Android"))
		{
			return driver.findElement(Home.menuIcon);
		}
		else 
		{
			return driver.findElement(com.cluster.repo.ui.ios.Home.menuIcon);
		}
	}
	public WebElement getSearchTextbox()
	{
		if(instanceName.contains("Android"))
		{
			return driver.findElement(Home.searchTextbox);
		}
		else 
		{
			return driver.findElement(com.cluster.repo.ui.ios.Home.searchTextbox);
		}
	}
}
