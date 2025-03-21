package com.qa.SauceDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.SauceDemo.TestBase.TestBase;

public class AddToCartPage extends TestBase{
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//div[@class='inventory_item_name ' and text()='Sauce Labs Backpack']")
	WebElement item_to_add;
	
	@FindBy(id="add-to-cart")
	WebElement addToCartButton;
	
	@FindBy(id="remove")
	WebElement removeButton;
	
	@FindBy(className="inventory_details_price")
	WebElement ItemPrice;
	
	public void addItemToCart() {
		item_to_add.click();
		addToCartButton.click();
	}
	
	public void validateRemoveButton() {
		if(!removeButton.isDisplayed())
		{
			System.out.println("remove action not displayed");
		}
	}
	
	public String getItemPrice()
	{
		return ItemPrice.getText();
	}

}
