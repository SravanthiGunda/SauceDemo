package com.qa.SauceDemo.Listener;

import com.aventstack.extentreports.Status;
import com.qa.SauceDemo.TestBase.TestBase;

	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;
	import java.io.File;
	import java.io.IOException;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.io.FileHandler;

	public class TestListener extends TestBase implements ITestListener {

	    @Override
	    public void onTestStart(ITestResult result) {
	    	extentTest = extent.createTest(result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	    	extentTest.log(Status.PASS, "Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	extentTest.log(Status.FAIL, "Test Failed: " + result.getThrowable().getMessage());

	        // Capture Screenshot on Failure
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String path = "test-output/screenshots/" + result.getName() + ".png";
	        try {
	            FileHandler.copy(screenshot, new File(path));
	            extentTest.fail("Screenshot:").addScreenCaptureFromPath(path);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	    	extentTest.log(Status.SKIP, "Test Skipped");
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
	}


