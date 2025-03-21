package com.qa.SauceDemo.TestBase;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qa.SauceDemo.Utilities.configReader;

public class TestBase {
	
	public static WebDriver driver; 
	
	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	 static configReader config;

	@BeforeSuite
	public static void startReporter()
	   {
	       extentSparkReporter = new ExtentSparkReporter(
	               System.getProperty("user.dir") + "/test-output/extentReport.html");
	       extent = new ExtentReports();
	       extent.attachReporter(extentSparkReporter);
	   }
	
	@BeforeTest
	public static void initialize() 
	{
		config = new configReader();
		
	String browser = config.getProperty("browser");
	
	if(browser.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(config.getProperty("url"));
	}  
	
	
	@AfterTest
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
	
	
	   
	  
}





