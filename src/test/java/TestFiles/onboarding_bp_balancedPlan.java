package TestFiles;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.numi.journal.pages.journalPage;
import com.numi.onboarding.pages.acctDetailsPage;
import com.numi.onboarding.pages.allSetPage;
import com.numi.onboarding.pages.chooseNSPlan;
import com.numi.onboarding.pages.chooseNsPlanListPage;
import com.numi.onboarding.pages.connectDevicePage;
import com.numi.onboarding.pages.firstWeekStagePage;
import com.numi.onboarding.pages.newSignUpPage;
import com.numi.onboarding.pages.setUpAcctPage;
import com.numi.onboarding.pages.signInPage;
import com.numi.onboarding.pages.stayOnTrackEMailNotifyPage;
import com.numi.onboarding.pages.tellUsprofilePage;
import com.numi.qa.base.baseClass;

public class onboarding_bp_balancedPlan extends baseClass {
	signInPage signInPg;
	newSignUpPage newSignUpPg;
	setUpAcctPage setUpAcctPg;
	acctDetailsPage acctDetailsPg;
	tellUsprofilePage tellUsprofilePg;
	chooseNSPlan chooseNsPln;
	chooseNsPlanListPage chooseNsPlanListPg;
	firstWeekStagePage firstWeekStagePg;
	stayOnTrackEMailNotifyPage stayOnTrackEMailNotifyPg;
	connectDevicePage connectDevicePg;
	allSetPage allSetPg;
	journalPage journalPg;

	public onboarding_bp_balancedPlan() {
		super();
	}

//verify on-boarding with newToNumi, choosing basic plan.
	@BeforeClass
	public void intiateDriver() {
		initialization();
		signInPg = new signInPage();
		driver.get(prop.getProperty("url"));
		waitForPageLoad(js);
		Assert.assertEquals(signInPg.verifyTitleSignInPg(), prop.getProperty("title"));
		System.out.println("===========================================================");
	}

	@Test(priority = 1)
	public void onb_newUser_signUpforNumiClick() {
		newSignUpPg = signInPg.signUpForNumiClick(); // returns new signup page
		setUpAcctPg = newSignUpPg.createNewNumiAcctBttnClick(); // returns setup account page
		System.out.println("===============================================================================");

	}

	@Test(priority = 2)
	public void onb_newUser_setUpAcctPage() {
		Assert.assertTrue(setUpAcctPg.verify_setUpAcctPageHeading(), "SetUp account page title is incorrect");
		acctDetailsPg = setUpAcctPg.setUpNewUserAcct(); // returns account details page where the user sets up email id
		System.out.println("==================================================================================");

	}

	@Test(priority = 3)
	public void onb_newUser_acctDetailsPage() {
		Assert.assertTrue(acctDetailsPg.verify_accDetailsPgHeading(), "Account details page title is incorrect");
		tellUsprofilePg = acctDetailsPg.setUpaccntDetailsPage();
		System.out.println("==================================================================================");
	}

	@Test(priority = 4)
	public void onb_newUser_tellUsprofilePage() {
		Assert.assertTrue(tellUsprofilePg.verify_tellUsAboutPageHeading(), "Tell Us About page title is incorrect");
		chooseNsPln = tellUsprofilePg.tellUsProfPage_MoreThan100();
		System.out.println("==================================================================================");
	}

	@Test(priority = 5)
	public void onb_newUser_chooseNSPlanPage() {
		Assert.assertTrue(chooseNsPln.verify_chooseNSPlanPg_Heading(), "Choose NS plan page title is incorrect");
		chooseNsPlanListPg = chooseNsPln.choosePlanButton();
		System.out.println("==================================================================================");
	}

	@Test(priority = 6)
	public void onb_newUser_chooseNsPlanListPage() {
		Assert.assertTrue(chooseNsPlanListPg.verify_chooseNSPlnListPg_Heading(),
				"Choose NSplan list page title is incorrect");
		stayOnTrackEMailNotifyPg=chooseNsPlanListPg.choose_BluePrint_Plan(chooseNsPlanListPg.bp_balancedPlan);
		System.out.println("==================================================================================");

	}

	
		
	@Test(priority = 7)
	public void onb_newUser_stayOnTrackEMailNotifyPage() throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue(stayOnTrackEMailNotifyPg.verify_stayOnTrackEMailNotifyPg_Heading(),"Email page title is incorrect");
		connectDevicePg = stayOnTrackEMailNotifyPg.yesEmailNotify();
		System.out.println("==================================================================================");
	}

	@Test(priority = 8)
	public void onb_newUser_connectDevicePage() {
		Assert.assertTrue(connectDevicePg.verify_connectDevicePg_Heading(), "Connect device page title is incorrect");
		allSetPg = connectDevicePg.connectDeviceNotNow();
		journalPg = allSetPg.noTourNow();
		System.out.println("==================================================================================");

	}

	@Test(priority = 9)
	public void onb_newUser_onboardingComplete() {
		Assert.assertTrue(journalPg.verify_journalPg_Heading(), "Journal page title is incorrect");
		journalPg.checkProfileNameDisplay();
		System.out.println("==================================================================================");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
