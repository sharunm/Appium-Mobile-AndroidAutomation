package org.saranLiveProjects;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;


public class Listeners implements ITestListener
{
	ExtentReports extent =ExtentReporterNG.getReporterObject();

	ExtentTest test;

	AppiumDriver driver;

	@Override

	public void onTestStart(ITestResult result) {

	test = extent.createTest(result.getMethod().getMethodName());
	}
	@Override

	public void onTestSuccess(ITestResult result) {

	test.log(Status.PASS, "Test passed");
	}
	@Override

	public void onTestFailure(ITestResult result) {

		test.fail(result.getThrowable());

		

//		try {

//			driver= (AndroidDriver<MobileElement>)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());

//			

//		} catch (Exception e1) {

//			e1.printStackTrace();

//		}

//		try {

//			test.addScreenCaptureFromPath(getScreenShotpath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());

//		} catch (Exception e) {

//			e.printStackTrace();

//		}

		

	}

	@Override

	public void onTestSkipped(ITestResult result) {

		// TODO Auto-generated method stub

		

	}
	@Override

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		// TODO Auto-generated method stub

	}

	@Override

	public void onStart(ITestContext context) {

		// TODO Auto-generated method stub

	}

	@Override

	public void onFinish(ITestContext context) {

	extent.flush();

		

	}
}
	


