package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LandingPage;
import utils.ConfigReader;
import utils.LogHelper;

@Listeners(listeners.TestListener.class)
public class LandingPageTests extends BaseTest {

	LandingPage landingPage;

	@BeforeMethod	
	public void landingPageSetupBeforeMethod() {
		landingPage = new LandingPage();
		landingPage.navigateToPage(ConfigReader.getBaseUrl());
		LogHelper.info("Current page is " + landingPage.getCurrentUrl());
	}

	@Test
	public void testLandingPageLoadsSuccessfully() {
		Assert.assertEquals(landingPage.getPageTitle(), "Numpy Ninja");
		Assert.assertEquals(landingPage.getCurrentUrl(), ConfigReader.getBaseUrl());
		LogHelper.info("Current page is " + landingPage.getCurrentUrl());
	}

	@Test
	public void testGetStarted() {
		landingPage.clickGetStartedLink();
		Assert.assertEquals(landingPage.getCurrentUrl(), ConfigReader.getHomeUrl());
		LogHelper.info("Current page is " + landingPage.getCurrentUrl());
	}
}
