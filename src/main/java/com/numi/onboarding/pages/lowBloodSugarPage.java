package com.numi.onboarding.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.numi.qa.base.baseClass;

public class lowBloodSugarPage extends baseClass {
	@FindBy(xpath = "//h3[@id='LOW_BLOOD_SUGAR']")
	WebElement bldSugarPage;

	public lowBloodSugarPage() {
		PageFactory.initElements(driver, this);
	}

	public void verifyHeading_lowBSugarPg() {
		String actual_headinglowBSPg = bldSugarPage.getText();
		System.out.println("Title of page is:" + actual_headinglowBSPg);
		if (actual_headinglowBSPg.equalsIgnoreCase(prop.getProperty("exp_headinglowBSPg"))) {
			System.out.println("Title of the page is correct");
		} else
			System.out.println("Title is incorrect");

	}
}
