package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {
	
	DriverFactory df;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	AccountsPage accountsPage;
	SearchResultsPage searchResultPage;
	ProductInfoPage productInfoPage;
	RegistrationPage registrationPage;
	SoftAssert softAssert;
	
	
	@Parameters({"browser", "browserversion"})
	@BeforeTest
	public void setup(String browser, String browserVersion) {
		df = new DriverFactory();
		prop = df.init_prop();
		
		if(browser!=null) {
			prop.setProperty("browser", browser);
			prop.setProperty("browserversion", browserVersion);
		}
		
		driver = df.init_driver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
