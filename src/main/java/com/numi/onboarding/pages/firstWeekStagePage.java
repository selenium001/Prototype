package com.numi.onboarding.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.numi.qa.base.baseClass;

public class firstWeekStagePage extends baseClass {
	
	@FindBy(xpath="//h6[contains(text(),'Stage Options')]")
	WebElement firstWkSatgePg_Heading;	
	
	@FindBy(xpath="//strong[@class='first_week_text']//strong")
	WebElement firstWkHeading;
	
	@FindBy(xpath="//label[@class='yes_text']")
	WebElement yesBttn;
	
	@FindBy(xpath="//label[@class='no_text']")
	WebElement noBttn;
	
	@FindBy(xpath="//div[@class='today_date']")
	WebElement weekOneEndsOnDropdwn;
	
	@FindBy(xpath= "//button[@class='btn disabled mt10p turbo_takeoff_continue continue_text']")
	WebElement firstWkPgContinueBttnDisable;
	
	@FindBy(xpath="//button[@class=' mt10p turbo_takeoff_continue continue_text']")
	WebElement firstWkPgContinueBttnEnable;
	
	public firstWeekStagePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verify_firstWeekStagePg_Heading() {
		w.until(ExpectedConditions.visibilityOf(firstWkSatgePg_Heading));
		return(firstWkSatgePg_Heading.isDisplayed());
	}
	
	public void verify_firstweekPageHeading() {
		if (firstWkHeading.isDisplayed()) {
			String ActualHeading =firstWkHeading.getText();
			System.out.println("Heading of first week page is :"+ActualHeading);
		}
		
	}
	public stayOnTrackEMailNotifyPage yesFirstWeek() {
		yesBttn.click();
		if(weekOneEndsOnDropdwn.isDisplayed()) {
			System.out.println("Week 1 dropdown is displayed as expected.");
		}else System.out.println("Week 1 dropdown is NOT DISPLAYED WHICH IS INCORRECT.");
		
		w.until(ExpectedConditions.elementToBeClickable(firstWkPgContinueBttnEnable));
		
		if(firstWkPgContinueBttnEnable.isDisplayed()){
			System.out.println("firstWkPgContinueBttnEnable is displayed");
			firstWkPgContinueBttnEnable.click();
		}else System.out.println("Not able to find continue buttton");
		return new stayOnTrackEMailNotifyPage();
		
	}

}
