package com.mywedding.basetest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class BaseTestCase {
	
	protected WebDriver driver;
	
	@Before
	public void setup() {
		
		ProfilesIni profile = new ProfilesIni();
		
		// Use a FirefoxProfile that was configured to always allowed to share location
		FirefoxProfile myProfile = profile.getProfile("TestAutomation");
		
		if (myProfile != null) {
			driver = new FirefoxDriver(myProfile);
		}
		else {
			// no such profile currently exists, use a default FirefoxDriver instead
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@After
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
		/*
		 * If org.openqa.selenium.os.UnixProcess$SeleniumWatchDog destroyHarder warning shows up
		 * in the log/console, consider downgrading your current version of Firefox, otherwise 
		 * the tests should still work.
		 */
	}
}
