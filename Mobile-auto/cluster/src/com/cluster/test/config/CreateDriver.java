package com.cluster.test.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.condition.And;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.cluster.utils.DataHandlers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class CreateDriver 
{
	public static AppiumDriver getDriverInstance() 
	{
		AppiumDriver driver = null;
		String platform = DataHandlers.getDataFromProperty("config-data", "platform");
		String deviceName = DataHandlers.getDataFromProperty("config-data", "device_name");
		String platformVersion = DataHandlers.getDataFromProperty("config-data",
				"platform_version");
		DesiredCapabilities cap = new DesiredCapabilities();
		if(platform.equalsIgnoreCase("aos"))
		{
			cap.setCapability("platform", "Android");
			cap.setCapability("appPackage", "com.flipkart.android");
			cap.setCapability("appActivity", "com.flipkart.android.SplashActivity");
			if(platformVersion.equals("5.0"))
			{
				cap.setCapability("platformVersion", "5.0");
			}
			else if(platformVersion.equals("6.0"))
			{
				cap.setCapability("platformVersion", "6.0.1");
			}
			if(deviceName.equalsIgnoreCase("device_5.0"))
			{
				cap.setCapability("deviceName", "192.168.196.101:5555");
			}
			else if(deviceName.equalsIgnoreCase("device_6.0"))
			{
				cap.setCapability("deviceName", "e79cd4b17d34");
			}
			try {
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(platform.equalsIgnoreCase("ios"))
		{
			cap.setCapability("platform", "ios");
			cap.setCapability("PlatformVersion", "10.0.1");
			cap.setCapability("deviceUDID", "");
			cap.setCapability("bundleID", "");
			try {
				driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.err.println("-------------Invalid Platform--------------------");
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}
}
