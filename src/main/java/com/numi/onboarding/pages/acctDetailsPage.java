package com.numi.onboarding.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.numi.qa.base.baseClass;
import com.numi.qa.base.randomEmail;

public class acctDetailsPage extends baseClass {
	
	@FindBy(xpath="//h3[contains(text(),'Set up your account details')]")
	WebElement acctDetailsPg_heading;

	@FindBy(xpath = "//input[@type='text' and @placeholder='Email']")
	WebElement EmailInpuBox;

	@FindBy(xpath = "//input[@type='password' and @placeholder='Password']")
	WebElement pwdInputField;

	@FindBy(xpath = "//span[@class='bullet_icon']")
	WebElement agreeTermsCheckBox;

	@FindBy(xpath = "//p[@class='email_box email_text']//span[@class='error']")
	WebElement emailErrorMsg;

	@FindBy(xpath = "//p[@class='password_field password_text']//span[@class='error']")
	WebElement pwdErrorMsg;

	@FindBy(xpath = "//input[@class='account_submit account_details_button_text']")
	WebElement SignUpBttn;

	public acctDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verify_accDetailsPgHeading() {
		return(acctDetailsPg_heading.isDisplayed());
	}

	public tellUsprofilePage setUpaccntDetailsPage() {
		EmailInpuBox.clear();
		String setUpemail= randomEmail.generateRandomEmail();
		EmailInpuBox.sendKeys(setUpemail);
		//System.out.println(setUpemail);
		pwdInputField.clear();
		pwdInputField.sendKeys(prop.getProperty("setUppassword"));
		//System.out.println("Password");
		agreeTermsCheckBox.click();
		SignUpBttn.click();
		return new tellUsprofilePage();

	}

	public void setUpaccntDetailsPage_verifyErrorMsgAppears() {
		// verify if error messages are appearing
		SignUpBttn.click();
		List<WebElement> errMessages = driver.findElements(By.className("error"));
		System.out.println("Number of error messages appearing ");
		for (int i = 0; i < errMessages.size(); i++) {
			System.out.println("======"+ errMessages.get(i).getText());
			if (errMessages.get(i).getText().equalsIgnoreCase(prop.getProperty("emlErrorMsg"))) {
				System.out.println("Error message for email is appearing as expected");
				continue;
			}
			
			if (errMessages.get(i).getText().equalsIgnoreCase(prop.getProperty("pwdErrorMsg"))) {
				System.out.println("Password error message is appearing as expected");
				break;
			} else {
				System.out.println("Error message for email or password is not appearing");
			}
		}
	}
}
