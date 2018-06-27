package com.demo.pageRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.demo.base.Base;
import com.relevantcodes.extentreports.LogStatus;

public class SearchedListPage extends Base{
	
	public List<WebElement> allMedList;
	public List<WebElement> rxMedList;
	
	
	public SearchedListPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void allSearchedMedicines()
	{
		allMedList = driver.findElements(By.xpath("//div[@class='medicine_lists']/div"));
	}
	
	public void SearchedMedicinesRX()
	{
		rxMedList = driver.findElements(By.xpath("//div[@class='medicine_lists']//div[contains(@class,'rx')]"));
	}
	
	public AddToCartPage selectRxMedicine()
	{
		SearchedMedicinesRX();
		rxMedList.get(0).click();
		extentTest.log(LogStatus.INFO,"Select medicine with RX tag and added to cart.");
		return new AddToCartPage(); 
	}

}
