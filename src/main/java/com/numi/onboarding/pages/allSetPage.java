package com.numi.onboarding.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.numi.journal.pages.journalPage;
import com.numi.qa.base.baseClass;

public class allSetPage extends baseClass {

	@FindBy (xpath="//a[@class='not_now not_now_device_text']")
	WebElement notNow_tour_Bttn;
	
	@FindBy (xpath="//button[@class='tap_tour_got_it take_a_tour_text']")
	WebElement takeATourBttn;
	
	public allSetPage() {
		PageFactory.initElements(driver, this);
	}
	
	public journalPage noTourNow() {
		w.until(ExpectedConditions.elementToBeClickable(notNow_tour_Bttn));
		notNow_tour_Bttn.click();
		System.out.println("No tour now");
		return new journalPage();
	}
}
