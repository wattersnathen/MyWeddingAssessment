package com.mywedding.pages;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mywedding.basetest.BaseTestCase;

/**
 * Test suite for tests related to the FindVendorPage
 * 
 * @author Nathen
 *
 */
public class FindVendorPageTest extends BaseTestCase {

	/**
	 * Sanity check test for ensuring that the user can in fact get to the find vendors page
	 * from the home page.
	 */
	@Test
	public void userCanNavigateToFindVendorPageFromHomePageTest() {
		FindVendorPage vendorPage = getToFindVendorPage();
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
		FindVendorPage vendorPage = getToFindVendorPage();
		Assert.assertEquals(FindVendorPage.FINDVENDORPAGE_URL, vendorPage.getURL());
		
		/* Then:
		 * 		the ideas search section is not present on the find vendor home page
		 */
		WebElement ideasSearch = driver.findElement(By.id("ideas-search"));
		Assert.assertFalse("ideas-search section should not be present on the Find Vendors Page", 
				ideasSearch.isDisplayed());			
	}	
	
	/**
	 * Make sure the ideas search section is not present (using the same function as above) 
	 * and verify that the find vendor search dropdown category is defaulted to venues. 
	 * <a href="http://prntscr.com/83e4tr"> View resource</a>.
	 */
	@Test
	public void ideasSearchIsNotPresentAndFindVendorDropdownDefaultsToVenues() {
		/* Given:
		 * 		I am on the find vendor home page
		 */
		FindVendorPage vendorPage = getToFindVendorPage();
		Assert.assertEquals(FindVendorPage.FINDVENDORPAGE_URL, vendorPage.getURL());
		
		/*
		 * 		And the ideas search section is not present on the find vendor home page
		 */
		WebElement ideasSearch = driver.findElement(By.id("ideas-search"));
		Assert.assertFalse("ideas-search section should not be present on the Find Vendors Page",
				ideasSearch.isDisplayed());
		
		/*
		 * 		And the find vendor home page category contains the correct default value "venues"
		 */
		Assert.assertEquals("venues", vendorPage.getDropdownButtonForCategoriesText());
	}
	
	/**
	 * Verify that the "Pay it Forward" section at the bottom has the desired bullet points 
	 * <a href="http://prntscr.com/83e5l0"> View resource</a>
	 */
	@Test
	public void payItForwardSectionContainsRatingAndFeedbackBullets() {
		/* Given:
		 * 		I am on the find vendor home page
		 */
		FindVendorPage vendorPage = getToFindVendorPage();
		Assert.assertEquals(FindVendorPage.FINDVENDORPAGE_URL, vendorPage.getURL());
		
		/*
		 *		And the find vendor home page checklist section is present 
		 */
		Assert.assertTrue("Expected checklist section to be present", vendorPage.checkListSectionIsPresent());
		
		/*
		 * When:
		 * 		I move to the find vendor home page checklist section
		 */
		vendorPage.moveToCheckListSection();
		
		/*
		 * Then:
		 * 		the find vendor home page pay it forward checklist items are present
		 * 		|leave rating and recommendations about vendors you used|
		 * 		|provide useful feedback to couples planning their wedding|
		 */
		
		String[] expectedBulletItemText = {
				"leave rating and recommendations about vendors you used",
				"provide useful feedback to couples planning their wedding"
		};
		
		List<WebElement> checkListItems = vendorPage.getHomePageChecklistItems();
		for (WebElement item : checkListItems) {
			
			// check for the Pay It Forward list item
			if (item.getAttribute("innerHTML").contains("pay it")) {
				
				Assert.assertArrayEquals("Expected pay it forward list item to contain " + expectedBulletItemText, 
						expectedBulletItemText,
						vendorPage.getChecklistItemBulletTextForItem(item).toArray());
				
			}
			
		}
	}
	
	// ----- HELPER METHODS -----
	
	/**
	 * Helper method for constructing and navigating the FindVendorPage
	 * 
	 * @return instance of FindVendorPage
	 */
	private FindVendorPage getToFindVendorPage() {
		HomePage homePage = new HomePage(driver).navigateToHomePage();
		FindVendorPage vendorPage = homePage.navigateToFindVendorPage();
		return vendorPage;
	}
}
