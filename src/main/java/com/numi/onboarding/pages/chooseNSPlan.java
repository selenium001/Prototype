package com.numi.onboarding.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.numi.qa.base.baseClass;

public class chooseNSPlan extends baseClass {
	@FindBy(xpath="//h3[contains(text(),'Choose Nutrisystem Plan')]")
	WebElement chooseNSPlanPg_Heading;
	
	@FindBy(xpath = "//button[@class='mt10p link_nutrisystem_account']")
	WebElement linkNsAcctBttn;
	
	@FindBy(xpath="//button[@class='choose_a_new_plan']")
	WebElement choosePlanBttn;
	
	public chooseNSPlan() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verify_chooseNSPlanPg_Heading() {
		return(chooseNSPlanPg_Heading.isDisplayed());
	}
	
	public chooseNsPlanListPage choosePlanButton() {
		choosePlanBttn.click();
		return new chooseNsPlanListPage();
	}
	
	
	
}
