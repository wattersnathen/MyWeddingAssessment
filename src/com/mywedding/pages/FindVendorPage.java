package com.mywedding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FindVendorPage extends Page {
	
	private WebDriver driver;
	
	protected static final String FINDVENDORPAGE_URL = "http://www.mywedding.com/home/find-vendor";
	
	public FindVendorPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, FindVendorPage.this);
	}
}
