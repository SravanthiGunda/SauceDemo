package com.qa.SauceDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.SauceDemo.TestBase.TestBase;

public class CheckOutPage extends TestBase{
	
	public static String Expected_Message;
	
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="checkout")
	WebElement checkoutButton;

	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id="last-name")
	WebElement lastName;
	
	@FindBy(id="postal-code")
	WebElement zipCode;
	
	@FindBy(id="continue")
	WebElement continuetButton;
	
	@FindBy(id="finish")
	WebElement finishButton;
	
	@FindBy(xpath="//h2[@class='complete-header' and text()='Thank you for your order!']")
	WebElement successMessage;
	
	public void checkOut(String fn, String ln, String zip) 
	{
		checkoutButton.click();
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		zipCode.sendKeys(zip);
		continuetButton.click();
		finishButton.click();
		
	}
	
	public String validateSucessMessage()
	{
		return successMessage.getText();
	}
	
	
	
	
	
	
	
	
	
}
