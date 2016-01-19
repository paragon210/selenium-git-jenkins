package com.cbs.testsuite;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.objects.Cbs_HomepageObject;
import page.objects.Cbs_SearchpageObject;

public class SearchResults_Test {
	private WebDriver driver;
	private Actions actions;
	private WebDriverWait wait;
	private Cbs_HomepageObject homepage;
	private Cbs_SearchpageObject searchpage;
	
	@BeforeTest
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 30);
		actions = new Actions(driver);
		homepage = new Cbs_HomepageObject();
	    searchpage = new Cbs_SearchpageObject();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(homepage.getBaseUrl());
	}
	
	@Test
	public void testSearchPage(){
		//driver.get(homepage.getBaseUrl());
		
		//Click the search icon on the home page
		wait.until(ExpectedConditions.visibilityOf(homepage.getImgClassElement(driver)));
		homepage.clickSearchIcon(driver, actions);
		
		//Wait for the page to load and the search box to appear. Enter the search term and click the search button.
		//TODO add auto complete check functionality
		//wait.until(ExpectedConditions.visibilityOf(homepage.getImgClassElement(driver)));
		wait.until(ExpectedConditions.visibilityOf(searchpage.getSearchBox(driver)));
		searchpage.enterSearchTerm(driver, actions);
		searchpage.clickSearchButton(driver, actions);
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
