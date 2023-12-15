package org.saranLiveProjects;

import org.openqa.selenium.WebDriver;
import org.saranLiveProjects.pageObjects.android.ProductCatalogue;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReporterNG {
	static ExtentReports extent;
	public static ExtentReports getReporterObject()
	{
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter .config().setReportName("Web Automation Testing");
		reporter.config().setDocumentTitle("Test Results");
		
	 extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Saranya");
	return extent;
	
	}
//	@Test
//public void intialDemo()
//{
//	ExtentTest test = extent.createTest("Intial Demo");
//	//System.setProperty("webdriver.chrome.driver","C:\\SeleniumWebDriver\\chrome Driver\\chromedriver 3.exe");
//	
//	WebDriverManager.chromedriver().setup();
//	WebDriver driver=new ChromeDriver();
//	driver.get("https://rahulshettyacademy.com");
//	System.out.println(driver.getTitle());
//	extent.flush();
//	driver.close();
//	test.fail("This method failed");
//	
//	
//}
	
//	@Test
//	public void sampleMethod()
//	{
//		formPage.setNameField("sara");
//		formPage.setGender("male");
//		formPage.setCountryOption("india");
//		ProductCatalogue productCatalogue =formPage.submitForm();
//		productCatalogue.addItemToCart(0);	
//	}
//	
}
