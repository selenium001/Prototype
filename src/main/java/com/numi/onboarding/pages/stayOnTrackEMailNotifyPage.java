package com.numi.onboarding.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.numi.qa.base.baseClass;

public class stayOnTrackEMailNotifyPage extends baseClass {
	
	@FindBy(xpath="//h3[contains(text(),'Don’t Miss Out')]")
	WebElement stayOnTrackEMailNotifyPg_Heading;
	
	@FindBy(xpath="//h3[@class='text-center stay_on_track_header_text']")
	WebElement emailNotifyPgHeading;

	@FindBy(xpath = "//button[@class='font18 ml15 mt10p continue_text']")
	WebElement notifyEmailContinueBttn;

	@FindBy(xpath = "//div[@class='toggle_switch round on']")
	WebElement toggleOnForEmail;

	@FindBy(xpath = "//div[@class='toggle_switch round off']")
	WebElement toggleOffForEmail;

	public stayOnTrackEMailNotifyPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verify_stayOnTrackEMailNotifyPg_Heading() {
		return(stayOnTrackEMailNotifyPg_Heading.isDisplayed());
	}	

	public connectDevicePage yesEmailNotify() {
//		w.until(ExpectedConditions.elementToBeClickable(toggleOffForEmail));
//		if (toggleOffForEmail.isDisplayed()) {
//			System.out.println("EMail notification is off by default");
//			toggleOffForEmail.click();
			w.until(ExpectedConditions.elementToBeClickable(notifyEmailContinueBttn));
			notifyEmailContinueBttn.click();
			return new connectDevicePage();
//		} 
//		else if(toggleOnForEmail.isDisplayed()) {
//			System.out.println("EMailnotification is on by default");
//			notifyEmailContinueBttn.click();
//		}
//		else {
//			System.out.println("Email page is not displayed as expected");;
//		}

	}

}
