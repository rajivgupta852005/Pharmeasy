package com.demo.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.demo.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports report;
	public static ExtentTest extentTest;
	public WebDriverWait wait;

	public void initialize() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/demo/config/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		openBrowser();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// Implicit wait time
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		getURL();
	}

	public void openBrowser() {
		String win = prop.getProperty("browserName");
		try {
			if (win.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (win.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
		} catch (Exception e) {
			System.out.println("Incorrect Browser Specified");
		}
	}

	public void getURL() {
		driver.get(prop.getProperty("url"));
	}

	// TestNG annotations
	@BeforeTest
	public void startSettings() {
		report = ExtentManager.getInstance();

	}

	@AfterTest
	public void endingSettings() {
		report.flush();
		driver.quit();
	}

	@BeforeMethod
	public void beforeStartTest(Method method) {
		extentTest = report.startTest(method.getName());
	}

	@AfterMethod
	public void afterStartTest() {
		report.endTest(extentTest);
	}
}
