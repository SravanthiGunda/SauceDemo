package SauceDemo.SauceDemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.SauceDemo.TestBase.TestBase;
import com.qa.SauceDemo.pages.AddToCartPage;
import com.qa.SauceDemo.pages.CheckOutPage;
import com.qa.SauceDemo.pages.LoginPage;



public class SauceDemoTest extends TestBase{
	
	LoginPage login = new LoginPage();;
	AddToCartPage addToCart = new AddToCartPage();;
	CheckOutPage checkOutPage = new CheckOutPage();;
	String Expected_Message = "Thank you for your order!";
	ExtentReports extent;
    ExtentTest test;
	
	
	
	@Test(priority=1)
	public void sauceDemoTest() throws InterruptedException {
		login.Login("standard_user", "secret_sauce");
		addToCart.addItemToCart();
		addToCart.validateRemoveButton();
		System.out.println("item price is: "+addToCart.getItemPrice());
		Thread.sleep(2000);
		driver.findElement(By.className("shopping_cart_link")).click();
		checkOutPage.checkOut("abc", "def", "12345");
		Assert.assertEquals(Expected_Message, checkOutPage.validateSucessMessage());
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.xpath("//a[@id='logout_sidebar_link' and text()='Logout']")).click();
	}
	
	
	
	
	

}
