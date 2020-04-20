package ExistingUser;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.numi.onboarding.pages.signInPage;
import com.numi.qa.base.baseClass;

public class existgUser_signInPageTest extends baseClass {

	signInPage signInPg;

	public existgUser_signInPageTest() {
		super();
	}

	@BeforeClass
	public void intiateDriver() {
		initialization();
		signInPg = new signInPage();
	}

	@Test(priority = 1)
	public void getUrl() {
		driver.get(prop.getProperty("url"));
	}

	@Test(priority = 2)
	public void signInTitleTest() {
		Assert.assertEquals(signInPg.verifyTitleSignInPg(), prop.getProperty("title"));
	}
	
	@Test (priority =3)
	
	public void existinguserSignIn() throws Throwable {
		signInPg.signIn(prop.getProperty("fn"), prop.getProperty("pwd"));
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='journal_hdr pull-left']")));
//		String actual = driver.getCurrentUrl();
//		String Expected = "https://www.numi.com/journal";
//		Assert.assertEquals(actual, Expected);
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}