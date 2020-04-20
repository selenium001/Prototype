package Regression;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.numi.journal.pages.journalPage;
import com.numi.onboarding.pages.newSignUpPage;
import com.numi.onboarding.pages.setUpAcctPage;
import com.numi.onboarding.pages.signInPage;
import com.numi.qa.base.baseClass;

public class regression_use_NSacctLink extends baseClass {
	signInPage signInPg;
	newSignUpPage newSignUpPg;
	setUpAcctPage setUpAcctPg;
	journalPage journalPg;

	public regression_use_NSacctLink() {
		super();
	}

	@BeforeTest
	public void onboardingUpto_setUpacctPg() {
		initialization();
		signInPg = new signInPage();
		driver.get(prop.getProperty("url"));
		waitForPageLoad(js);

	}

	@Test
	public void useYrNsAccount() {
		newSignUpPg = signInPg.signUpForNumiClick(); // returns new signup page
		journalPg = newSignUpPg.UseYourNutriAcctBttnClick();
		Assert.assertTrue(journalPg.verify_journalPg_Heading(), "Journal page title is incorrect");
		journalPg.checkProfileNameDisplay();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}
