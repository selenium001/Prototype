package com.numi.onboarding.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.numi.qa.base.baseClass;

public class tellUsprofilePage extends baseClass {
	@FindBy(xpath = "//h3[contains(text(),'Tell us about yourself')]")
	WebElement tellUsProfPg_heading;

	@FindBy(xpath = "//select[@id='month_drop']")
	WebElement DOBMonth;

	@FindBy(xpath = "//select[@id='month_drop']//option[@value='1']")
	WebElement January;

	@FindBy(xpath = "//select[@id='pick_date']")
	WebElement DOBDay;

	@FindBy(xpath = "//select[@id='pick_date']//option[@value='2']")
	WebElement DOBDay2;

	@FindBy(xpath = "//select[@id='Year_drop']")
	WebElement DOBYear;

	@FindBy(xpath = "//select[@id='Year_drop']//option[@value='50']")
	WebElement DOBYear50;

	@FindBy(xpath = "//input[@id='height_feet']")
	WebElement hghtFeet;

	@FindBy(xpath = "//input[@id='height_inch']")
	WebElement hghtInch;

	@FindBy(xpath = "//input[@id='current_weight']")
	WebElement crntWeight;

	@FindBy(xpath = "//input[@id='goal_weight']")
	WebElement goalWeight;

	@FindBy(xpath = "//div[@class='react-datepicker__input-container']")
	WebElement startDate;

	@FindBy(xpath = "//div[@class='react-datepicker__month-container']")
	WebElement monthCalendar;

	@FindBy(xpath = "//div[contains(@aria-label, 'Choose')]")
	WebElement validDates;

	@FindBy(xpath = "//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")
	WebElement prevsMonthBttn;
	
	@FindBy(xpath="//input[@id='start_weight']")
	WebElement startWeight;
	
	@FindBy(xpath = "//input[@class='submit_btn continue_text']")
	WebElement continueBttn;

	@FindBy(xpath = "//input[@class='submit_btn continue_text btn disabled']")
	WebElement continueDisable;

	public tellUsprofilePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verify_tellUsAboutPageHeading() {
		return (tellUsProfPg_heading.isDisplayed());
	}

	public void startDate_backdated() {
		startDate.click();
		w.until(ExpectedConditions.visibilityOf(monthCalendar));
		if (monthCalendar.isDisplayed()) {
			System.out.println("Calendar is open");
			prevsMonthBttn.click();
			System.out.println("prevsMonthBttn in clicked");
		} else
			System.out.println("Calendar is not available");
		validDates.click(); // click on valid date
	}

	public chooseNSPlan tellUsProfPage_LessThan100_backdated() {
		DOBMonth.click();
		January.click();
		DOBDay.click();
		DOBDay2.click();
		DOBYear.click();
		DOBYear50.click();
		hghtFeet.sendKeys(prop.getProperty("hghtFeet"));
		hghtInch.sendKeys(prop.getProperty("hghtInch"));
		crntWeight.sendKeys(prop.getProperty("crtWght"));
		goalWeight.sendKeys(prop.getProperty("lessThan100goalWght"));
		startDate_backdated();
		startWeight.sendKeys(prop.getProperty("strtWght"));
		continueBttn.click();
		return new chooseNSPlan();

	}

	public chooseNSPlan tellUsProfPage_MoreThan100() {
		DOBMonth.click();
		January.click();
		DOBDay.click();
		DOBDay2.click();
		DOBYear.click();
		DOBYear50.click();
		hghtFeet.sendKeys(prop.getProperty("hghtFeet"));
		hghtInch.sendKeys(prop.getProperty("hghtInch"));
		crntWeight.sendKeys(prop.getProperty("crtWght"));
		goalWeight.sendKeys(prop.getProperty("moreThan100goalWght"));
		continueBttn.click();
		return new chooseNSPlan();

	}

}
