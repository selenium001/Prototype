package com.numi.onboarding.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.numi.qa.base.baseClass;

public class connectDevicePage extends baseClass {
	
	@FindBy(xpath="//h3[contains(text(),'Connect your device')]")
	WebElement connectDevicePg_Heading;
	
	@FindBy(xpath="//a[@class='not_now not_now_device_text not_now_connect_device']")
	WebElement notNow_device_Bttn;
	
	public connectDevicePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verify_connectDevicePg_Heading() {
		return(connectDevicePg_Heading.isDisplayed());
	}
	
	public allSetPage connectDeviceNotNow() {
		w.until(ExpectedConditions.elementToBeClickable(notNow_device_Bttn));
		notNow_device_Bttn.click();
		System.out.println("Not connecing to device now");
		return new allSetPage();
	}
	
	

}
