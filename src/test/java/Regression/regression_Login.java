package Regression;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.numi.journal.pages.journalPage;
import com.numi.onboarding.pages.signInPage;
import com.numi.qa.base.baseClass;
import com.numi.qa.base.keywordFunctions;

public class regression_Login extends baseClass {

	keywordFunctions kf = new keywordFunctions();
	journalPage jp = new journalPage();
	signInPage signInPg;

	public regression_Login() {		
		super();
		System.out.println("In regression_Login.constructor");
	}

	@BeforeTest
	public void intiateDriver() {
		System.out.println("In regression_Login.intiateDriver");
		initialization();
		kf.getUrl(prop.getProperty("url"));
		signInPg= new signInPage();
		waitForPageLoad(js);
	}

	@Test
	public void login_existingUser() {
		jp = signInPg.signIn(prop.getProperty("fn"), prop.getProperty("pwd"));
		Assert.assertEquals(jp.checkProfileNameDisplay(), prop.getProperty("profileName"));
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
