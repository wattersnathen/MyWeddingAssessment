package com.mywedding.pages;

import org.junit.Assert;
import org.junit.Test;

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
	

}
