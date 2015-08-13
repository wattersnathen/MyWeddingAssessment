package com.mywedding.pages;

import org.openqa.selenium.WebDriver;

/**
 * Abstract base class for all Page classes. 
 * 
 * @author Nathen
 *
 */
public abstract class Page {
	
	protected WebDriver driver;
	
	protected Page(final WebDriver driver) {
		this.driver = driver;
	}
	
	public String getURL() {
		return driver.getCurrentUrl();
	}
}
