package com.demo.pageRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.base.Base;
import com.relevantcodes.extentreports.LogStatus;

public class UploadPrescriptionPage extends Base {

	@FindBy(xpath = "//button[@class='uploadPrescriptionBtn']//preceding-sibling::input")
	WebElement uploadPrescriptionBtn;

	@FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
	WebElement proceedToCheckoutBtn;

	public UploadPrescriptionPage() {
		PageFactory.initElements(driver, this);
	}

	public void uploadPrescription() throws InterruptedException {
		String filepath = System.getProperty("user.dir") + "\\SamplePrescription.jpg";
		wait = new WebDriverWait(driver,5);
		uploadPrescriptionBtn.sendKeys(filepath);
		extentTest.log(LogStatus.INFO,"Uploaded Precscription");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='block-background']")));
		
	}

	public LoginPage proceedToChechout() {
		proceedToCheckoutBtn.click();
		extentTest.log(LogStatus.INFO,"Click on PROCEED TO CHECKOUT button.");
		return new LoginPage();
	}
}
