package com.mywedding.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindVendorPage extends Page {
	
	private WebDriver driver;
	
	protected static final String FINDVENDORPAGE_URL = "http://www.mywedding.com/home/find-vendor";
	
	@FindBy(css="#category button")
	private WebElement dropdownButton;
	
	@FindBy(css="#tab-pane-find-vendor > div.homepage-checklist > div > h6")
	private WebElement homePageChecklist;
	
	@FindBy(css="#tab-pane-find-vendor > div.homepage-checklist > div > div.row > div.col-sm-4")
	private List<WebElement> checkListItems;
	
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
	
	/**
	 * Create an Actions builder to move to the homepage checklist section
	 */
	public void moveToCheckListSection() {
		Actions builder = new Actions(driver);
		builder.moveToElement(homePageChecklist)
			   .build()
			   .perform();
	}
	
	/**
	 * Get a List of all the homepage checklist items
	 * 
	 * @return List of items
	 */
	public List<WebElement> getHomePageChecklistItems() {
		return checkListItems;
	}
	
	/**
	 * Find the bullet item text for a given checklist item
	 * 
	 * @param checklistItem homepage checklist item to search
	 * @return List of all bullet text found
	 */
	public List<String> getChecklistItemBulletTextForItem(WebElement checklistItem) {
		List<String> bulletText = new ArrayList<>();
		
		List<WebElement> descriptiveTags = checklistItem.findElements(By.tagName("dd"));
		for (WebElement ddTag : descriptiveTags) {
			bulletText.add(ddTag.getText());
		}
		
		return bulletText;
	}
	
	
}
