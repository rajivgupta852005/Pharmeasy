package com.demo.pageRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.base.Base;
import com.relevantcodes.extentreports.LogStatus;

public class AddToCartPage extends Base {

	@FindBy(xpath = "//div[contains(@class,'showDesktop')]/button[text()='ADD TO CART']")
	WebElement addtoCartBtn;
	
	@FindBy(xpath = "//a[@href='/cart' and starts-with(@class,'gotoCartPdp')]")
	WebElement viewCartBtn;
	
	@FindBy(xpath = "//li[contains(@class,'HeaderCart')]/a")
	WebElement cartIcon;
	
	public AddToCartPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void addToCart()
	{
		addtoCartBtn.click();
	}
	
	public CartPage viewCart()
	{
		viewCartBtn.click();
		extentTest.log(LogStatus.INFO,"Clicked on View Cart button");
		return new CartPage();
	}
	
	
}
