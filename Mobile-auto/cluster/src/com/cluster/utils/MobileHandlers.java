package com.cluster.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
public class MobileHandlers
{
	public static void enableNetwork(AppiumDriver driver) 
	{
		//
	}
	public static void disableNetwork(AppiumDriver driver)
	{
		//
	}
	public static void rotateLandscape(AppiumDriver driver)
	{
		String orientation_type = driver.getOrientation().toString();
		if(orientation_type.contains("Protrait"))
		{
			driver.rotate(ScreenOrientation.LANDSCAPE);
		}
	}
	public static void rotatePotrait(AppiumDriver driver)
	{
		String orientation_type = driver.getOrientation().toString();
		if(orientation_type.contains("Landscape"))
		{
			driver.rotate(ScreenOrientation.PORTRAIT);
		}
	}
	public static void swipeScreen(AppiumDriver driver) 
	{
		Dimension d = driver.manage().window().getSize();
		int width = d.getWidth();
		int height = d.getHeight();
		int startx = width * 80/100;
		int starty = height * 45/100;
		int endx = 0;
		int endy = 0;
		TouchAction act = new TouchAction(driver);
		act.moveTo(startx, starty).press(startx, starty);
	}
	// Develop functionality to Scroll a screen and long press
}
