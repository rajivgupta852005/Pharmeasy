package com.demo.pageRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.base.Base;

public class LoginPage extends Base{
	
	@FindBy(xpath = "//div[@class='loginBoxContainer']")
	public WebElement loginBox;
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	

}
