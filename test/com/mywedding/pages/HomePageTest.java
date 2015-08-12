package com.mywedding.pages;

import org.junit.Test;
import org.testng.Assert;

import com.mywedding.basetest.BaseTestCase;

public class HomePageTest extends BaseTestCase {
	
	@Test
	public void ideasSearchSectionIsPresentOnHomePage() {
		HomePage homePage = new HomePage(driver).navigateToHomePage();
		Assert.assertTrue(homePage.isIdeasSearchElementPresent(), "Expected ideas search "
				+ "section to be present on home page");
	}
}
