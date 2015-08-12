package com.mywedding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * HomePage class used to represent the page that first loads
 * when a user navigates to 'www.mywedding.com'. 
 * 
 * @author Nathen
 *
 */
public class HomePage extends Page {
	
	private WebDriver driver;
	
	protected static final String HOMEPAGE_URL = "http://www.mywedding.com";
	
	// Page Elements
	@FindBy(id="tab-find-vendor")
	private WebElement vendorTab;
	
	/**
	 * Constructor for HomePage. Has a dependency for a WebDriver instance, and will 
	 * setup WebElements using Selenium's PageFactory.
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, HomePage.this);
	}
	
	/**
	 * Simulate the user clicking the "FIND VENDORS" tab.
	 * 
	 * @return instance of FindVendorPage
	 */
	public FindVendorPage navigateToFindVendorPage() {
		vendorTab.click();
		return new FindVendorPage(this.driver);
	}
}
