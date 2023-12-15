package org.saranLiveProjects.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public abstract class AppiumUtils {

	
	public String getScreenshotPath(String testCaseName,AppiumDriver driver) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"//reports"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
//	public void waitForElementToAppear(WebElement ele, AppiumDriver driver)
//	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//	    wait.until(ExpectedConditions.attributeContains(ele)), "text", "Cart"));
//	}
}
