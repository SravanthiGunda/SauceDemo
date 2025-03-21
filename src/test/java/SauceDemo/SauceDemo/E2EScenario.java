package SauceDemo.SauceDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class E2EScenario {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000)); 
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).submit(); 
		
		Select productSort = new Select(driver.findElement(By.className("product_sort_container")));
		
		productSort.selectByValue("lohi");
		
		Thread.sleep(50000);
		driver.findElement(By.xpath("//div[@class='inventory_item_name ' and text()='Sauce Labs Backpack']")).click();
		WebElement itemPrice = driver.findElement(By.className("inventory_details_price"));
		System.out.println("item price is: "+itemPrice.getText());
		driver.findElement(By.id("add-to-cart")).click();
		WebElement remove_button = driver.findElement(By.id("remove"));
		if(! remove_button.isDisplayed())
		{
			System.out.println("remove action not displayed");
		}
		driver.findElement(By.className("shopping_cart_link")).click();
		WebElement continue_shopping = driver.findElement(By.id("continue-shopping"));
		if(! continue_shopping.isDisplayed())
		{
			System.out.println("Continue shopping not displayed");
		}
		driver.findElement(By.name("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("tom");
		driver.findElement(By.id("last-name")).sendKeys("charles");
		driver.findElement(By.id("postal-code")).sendKeys("98765");
		driver.findElement(By.id("continue")).click();
		
		driver.findElement(By.id("finish")).click();
		
		WebElement Actual_msg = driver.findElement(By.xpath("//h2[@class='complete-header' and text()='Thank you for your order!']"));
		
		String Expected_msg = "Thank you for your order!";
		
		Assert.assertEquals(Expected_msg, Actual_msg.getText(), "order is not successful");
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.xpath("//a[@id='logout_sidebar_link' and text()='Logout']")).click();
		
		
		

	}

}
