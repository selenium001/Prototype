package customListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.numi.qa.base.keywordFunctions;

public class Listeners implements ITestListener  {
	keywordFunctions kf = new keywordFunctions();

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed");
	kf.takeScreenShotOnTestFail();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
}