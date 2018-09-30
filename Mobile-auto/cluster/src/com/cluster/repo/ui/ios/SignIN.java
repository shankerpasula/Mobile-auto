package com.cluster.repo.ui.ios;

import org.openqa.selenium.By;

public interface SignIN 
{
	By email = By.xpath("com.flipkart.android:id/mobileNo");
	By emailTextboxPoupMenuCancel = By.id("com.google.android.gms:id/cancel");
	By password = By.id("com.flipkart.android:id/et_password");
	By signIn = By.id("com.flipkart.android:id/btn_mlogin");
	By errorMsg = By.id("com.flipkart.android:id/btn_mlogin");
}
