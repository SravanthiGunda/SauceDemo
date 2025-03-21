package com.qa.SauceDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.SauceDemo.TestBase.TestBase;

public class LoginPage extends TestBase{
	
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	public void Login(String user, String pwd)
	{
		userName.sendKeys(user);
		password.sendKeys(pwd);
		loginButton.submit();
		
	}

}
