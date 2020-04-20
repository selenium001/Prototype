package com.numi.onboarding.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.numi.journal.pages.journalPage;
import com.numi.qa.base.baseClass;

public class newSignUpPage extends baseClass {
	
	@FindBy(xpath="//p[@class='nutri_account_txt color6']")
	WebElement UseYourNutriAcctBttn;
	
	@FindBy(xpath="//span[@class='numi_account_txt']")
	WebElement createNewNumiAcctBttn;
	
	@FindBy(xpath="//input[@id='nutri_email']")
	WebElement nsEmailInputBox;
	
	@FindBy(xpath="//input[@id='nutri_password']")
	WebElement nsPwdInputBox;
	
	@FindBy(xpath="//input[@type='submit' and @class='signup_numi']")
	WebElement signInWithNsBttn_Enabled;
	
	public newSignUpPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void verify_NewSignUpPgUrl() {
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, prop.getProperty("newSignUpPageUrl"));
		System.out.println("======================");
		
	}
	public setUpAcctPage createNewNumiAcctBttnClick() {
		w.until(ExpectedConditions.visibilityOf(createNewNumiAcctBttn));
		String newNumiActualText =createNewNumiAcctBttn.getText();
		System.out.println("This is New to Numi Bttn Text: "+newNumiActualText);
		
		if (newNumiActualText.equalsIgnoreCase(prop.getProperty("newNumiText"))) {
			System.out.println("Button text is correct");
				}else System.out.println("New to Numi button text is Incorrect");
		
		createNewNumiAcctBttn.click();	
		System.out.println("======================");
		return new setUpAcctPage();
	}
	
	public journalPage UseYourNutriAcctBttnClick() {
		String Actual_NutriAcctBttn_Text = UseYourNutriAcctBttn.getText();
		System.out.println("This is NutriSystem account Bttn Text: "+Actual_NutriAcctBttn_Text);
		if (Actual_NutriAcctBttn_Text.equalsIgnoreCase(prop.getProperty("NSAcctText"))) {
			System.out.println("NS button text is correct");
		}else System.out.println("NS button text is Incorrect");
		
		UseYourNutriAcctBttn.click();
		if (nsEmailInputBox.isDisplayed() && nsPwdInputBox.isDisplayed() ) {
			nsEmailInputBox.sendKeys(prop.getProperty("nsEmail"));
			nsPwdInputBox.sendKeys(prop.getProperty("nspwd"));
			signInWithNsBttn_Enabled.click();				
		}else System.out.println("The NS input boxes are  displayed");
		System.out.println("======================");
		return new journalPage();
		
			}
	}
	
	

