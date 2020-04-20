package com.numi.qa.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class keywordFunctions extends baseClass{

	public void getUrl(String url) {
		driver.get(url);
	}
	
	
	public void takeScreenShotOnTestFail() {
		System.out.println("Test is failed");
		File outputFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(outputFile,new File("\\eclipse-workspace\\Prototype\\ScreenShots\\ScreenShots.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
