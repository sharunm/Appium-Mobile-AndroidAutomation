package org.saranLiveProjects.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {
AndroidDriver driver;
	public AndroidActions(AndroidDriver driver)
	{
		this.driver = driver;
		
	}
	public void LongPressFunction(WebElement ele) 
	{
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "duration",2000));
			
			
	}
	public void SwipeDemoFunction(WebElement fimg, String direction) 
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement)fimg).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
			
			
	}
	
	public void DragDropFunction(WebElement source) 
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement)source).getId(),
			    "endX", 653,
			    "endY", 584
			));
			
			
	}
	public Double getFormattedamount(String amt)
	{
		Double price = Double.parseDouble((amt).substring(1));
		return price;
	}
	
	public void scrollToText(String country)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+country+"\"));"));
	}
	
	
	
}
