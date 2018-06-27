package com.demo.pageRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.base.Base;
import com.relevantcodes.extentreports.LogStatus;

public class CartPage extends Base {
	
	@FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
	WebElement proceedToCheckoutBtn;
	
	public CartPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public UploadPrescriptionPage proceedToChechout()
	{
		proceedToCheckoutBtn.click();
		extentTest.log(LogStatus.INFO,"Click on PROCEEDTOCHECKOUT button");
		return new UploadPrescriptionPage();
	}

}
