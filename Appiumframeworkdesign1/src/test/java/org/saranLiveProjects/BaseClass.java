package org.saranLiveProjects;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.saranLiveProjects.pageObjects.android.FormPage;
import org.saranLiveProjects.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseClass extends AppiumUtils {
	
	public AndroidDriver driver;
	FormPage formPage;
	@BeforeClass
public void ConfigureAppium() throws MalformedURLException
	{
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("UniverseEmulator");
		options.setChromedriverExecutable("C:\\SeleniumWebDriver\\chromedriver.exe");
		//options.setApp("C:\\Users\\sridh\\eclipse-workspace\\AppiumMobileAuto1\\src\\test\\java\\Utilities\\ApiDemos-debug (2).apk");
		options.setApp("C:\\APK Files\\General-Store.apk");
		//options.setPlatformName("Android");
		
	 driver = new AndroidDriver(new URL( "http://127.0.0.1:4723"),options);
	 formPage = new FormPage(driver);
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
//	@AfterClass
//	public void tearDown()
//	{
//		//driver.close();
//		driver.quit();
//	}
}
