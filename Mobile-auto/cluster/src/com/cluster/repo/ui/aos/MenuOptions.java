package com.cluster.repo.ui.aos;

import org.openqa.selenium.By;

public interface MenuOptions 
{
	By myAccount = By.xpath("//android.widget.TextView[@text='My Account']");
	By myOrders = By.xpath("//android.widget.TextView[@text='My Orders']");
}
