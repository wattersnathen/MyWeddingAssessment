package com.mywedding.pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mywedding.basetest.BaseTestCase;

public class FindVendorPageTest extends BaseTestCase {

	/**
	 * Sanity check test for ensuring that the user can in fact get to the find vendors page
	 * from the home page.
	 */
	@Test
	public void userCanNavigateToFindVendorPageFromHomePageTest() {
		HomePage homePage = new HomePage(driver).navigateToHomePage();
		FindVendorPage vendorPage = homePage.navigateToFindVendorPage();
		Assert.assertEquals(FindVendorPage.FINDVENDORPAGE_URL, vendorPage.getURL());
	}
	
	/**
	 * The ideas search section is <a href="http://prntscr.com/83e3tq"> this</a>, and we 
	 * only want that to be present on the "Collect Ideas" tab, not the "Find Vendors" tab.
	 */
	@Test
	public void ideasSearchSectionIsNotPresentOnTheFindVendorsPage() {
		/* Given:
		 * 		I am on the find vendor home page
		 */
		HomePage homePage = new HomePage(driver).navigateToHomePage();
		FindVendorPage vendorPage = homePage.navigateToFindVendorPage();
		Assert.assertEquals(FindVendorPage.FINDVENDORPAGE_URL, vendorPage.getURL());
		
		/* Then:
		 * 		the ideas search section is not present on the find vendor home page
		 */
		WebElement ideasSearch = driver.findElement(By.id("ideas-search"));
		Assert.assertFalse("ideas-search section should not be present on the Find Vendors Page", 
				ideasSearch.isDisplayed());			
	}
}
