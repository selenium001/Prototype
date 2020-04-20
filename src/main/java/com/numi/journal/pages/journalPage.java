package com.numi.journal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.numi.qa.base.baseClass;

public class journalPage extends baseClass {
	
	@FindBy(xpath="//h1[contains(text(),'Journal')]")
	WebElement journalPg_Heading; 
	
	@FindBy (xpath= "//span[@class='relative cursor_pointer']")
	WebElement userFirstname;
	
	public journalPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verify_journalPg_Heading() {
		return(journalPg_Heading.isDisplayed());
	}
	public String checkProfileNameDisplay() {
		String ActualFn= userFirstname.getText();
		System.out.println("Profile name: "+ActualFn);
		return ActualFn;
//		if (ActualFn.equalsIgnoreCase(prop.getProperty("firstName"))) {
//			System.out.println("Onboarding for "+ActualFn+" is successfull!!");
//		}else System.out.println("Firstname is not matching, onboarding unsuccessfull!!");
			
	}
}
