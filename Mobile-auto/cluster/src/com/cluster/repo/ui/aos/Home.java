package com.cluster.repo.ui.aos;

import org.openqa.selenium.By;

public interface Home
{
	By menuIcon = By.xpath("//android.widget.ImageButton[@content-desc='Open Drawer']");
	By searchTextbox = By.id("com.flipkart.android:id/search_widget_textbox");
}
