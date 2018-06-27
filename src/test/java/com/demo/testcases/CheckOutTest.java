package com.demo.testcases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.base.Base;
import com.demo.pageRepo.AddToCartPage;
import com.demo.pageRepo.CartPage;
import com.demo.pageRepo.HomePage;
import com.demo.pageRepo.LoginPage;
import com.demo.pageRepo.SearchedListPage;
import com.demo.pageRepo.UploadPrescriptionPage;
import com.relevantcodes.extentreports.LogStatus;

public class CheckOutTest extends Base {

	public HomePage homeVar;
	public SearchedListPage srcListPge;
	public AddToCartPage addCartPge;
	public CartPage cartPge;
	public UploadPrescriptionPage uploadPrePge;
	public LoginPage loginPge;

	@BeforeMethod
	public void beforeStartTest(Method method) {
		super.beforeStartTest(method);
		//lextentTest = report.startTest(method.getName());
		initialize();
		homeVar = new HomePage();
	}

	@Test
	public void prescribeAndCheckout() throws InterruptedException {
		homeVar.changeLocation();
		srcListPge = homeVar.headerSearch("acne");
		addCartPge = srcListPge.selectRxMedicine();
		addCartPge.addToCart();
		cartPge = addCartPge.viewCart();
		uploadPrePge = cartPge.proceedToChechout();
		uploadPrePge.uploadPrescription();
		loginPge = uploadPrePge.proceedToChechout();
		Assert.assertTrue(loginPge.loginBox.isDisplayed());
		Thread.sleep(500);
		extentTest.log(LogStatus.INFO,"Reached Login page --> END OF TEST.");
	}

}
