package com.demo.pageRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.base.Base;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends Base {

	String city = prop.getProperty("location");

	// Home page WebElement factory
	@FindBy(xpath = "//button[contains(@class,'cityContainerWeb ')]")
	WebElement locationBtn;

	@FindBy(xpath = "//input[@class='searchInputHeader']")
	WebElement headerSearchBox;

	@FindBy(xpath = "//button[contains(@class,'searchBtnHeader') and @data-reactid='68']")
	WebElement searchBtn;

	@FindBy(xpath = "//div[@class='city']")
	WebElement location;

	@FindBy(xpath = "//div[@class='searchContainer']/input")
	WebElement searchCity;

	@FindBy(xpath = "//div[@class='citiesListContainer']//div[@class='nonSelectedCircle']")
	WebElement selectCity;

	@FindBy(xpath = "//button[text()='APPLY']")
	WebElement applyBtn;

	@FindBy(xpath = "//div/span[text()='View All Results']")
	WebElement viewAllResults;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void changeLocation() {
		
		extentTest.log(LogStatus.INFO,"Default location selected as " + location.getText());
		if (!(location.getText()).equalsIgnoreCase(city)) {
			locationBtn.click();

			searchCity.sendKeys(city);

			List<WebElement> cityList = driver.findElements(By.xpath("//div[@class='citiesListContainer']/div"));
			for (WebElement citys : cityList) {
				if ((citys.getText()).equalsIgnoreCase(city)) {
					citys.click();
				}
			}
			applyBtn.click();
			extentTest.log(LogStatus.INFO,"Changed location to " + prop.getProperty("location"));
			
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='fade in modal']")));
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='searchInputHeader']")));
			wait.until(ExpectedConditions.elementToBeClickable(headerSearchBox));
		}
		
		/*try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public SearchedListPage headerSearch(String searchText) {
		headerSearchBox.click();
		headerSearchBox.sendKeys(searchText);
		extentTest.log(LogStatus.INFO,"Entered text \""+searchText+"\" in header serach box.");
		searchBtn.click();
		viewAllResults.click();
		return new SearchedListPage();

	}
}
