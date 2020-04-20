package com.numi.onboarding.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.numi.journal.pages.journalPage;
import com.numi.qa.base.baseClass;

public class signInPage extends baseClass {
	// Page Factory Object Repository
	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//p//input[@type='submit' and @value='Log In']")
	WebElement submit;

	@FindBy(xpath = "//a[@class='sign_up_for_numi_text']")
	WebElement dontHaveAcct_signUpForNumiLink;

	// Initializing the page objects
	public signInPage() {
		System.out.println("In signInPage constructor");
		PageFactory.initElements(driver, this);
		System.out.println("Out signInPage constructor, driver = "+driver+", "+this+" ="+this);
	}

	public String verifyTitleSignInPg() {
		System.out.println("This is the title method");
		String Title = driver.getTitle();
		System.out.println(Title);
		return Title;
	}

	public journalPage signIn(String fn, String pwd) {
		email.sendKeys(fn);
		password.sendKeys(pwd);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p//input[@type='submit']")));
		submit.click();
		return new journalPage();
	}
	
	public newSignUpPage signUpForNumiClick() {
		w.until(ExpectedConditions.visibilityOf(dontHaveAcct_signUpForNumiLink));
		dontHaveAcct_signUpForNumiLink.click();
		return new newSignUpPage();
	}

}
