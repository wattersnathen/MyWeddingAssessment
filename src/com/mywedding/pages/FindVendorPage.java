package com.mywedding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindVendorPage extends Page {
	
	private WebDriver driver;
	
	protected static final String FINDVENDORPAGE_URL = "http://www.mywedding.com/home/find-vendor";
	
	@FindBy(css="#category button")
	private WebElement dropdownButton;
	
	@FindBy(css="#tab-pane-find-vendor > div.homepage-checklist > div > h6")
	private WebElement homePageChecklist;
	public FindVendorPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, FindVendorPage.this);
	}
	
	public String getDropdownButtonForCategoriesText() {
		return dropdownButton.getText();
	}
	
	/**
	 * Method for checking if the homepage-checklist section is present. If the heading is showing then
	 * we can say the section is visible on the page.
	 * @return
	 */
	public boolean checkListSectionIsPresent() {	
		return homePageChecklist.isDisplayed();
	}
	
}
