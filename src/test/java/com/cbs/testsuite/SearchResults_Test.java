package com.cbs.testsuite;



import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.annotations.Test;

public class SearchResults_Test extends TestSuiteBase{

	
	@Test(groups = { "regression" })
	public void testSearchPage(){	
		//Click the search icon on the home page
		wait.until(ExpectedConditions.visibilityOf(homepage.getImgClassElement(driver)));
		homepage.clickSearchIcon(driver, actions);
		
		//Wait for the page to load and the search box to appear. Enter the search term and click the search button.
		//TODO add auto complete check functionality
		wait.until(ExpectedConditions.visibilityOf(searchpage.getSearchBox(driver)));
		searchpage.enterSearchTerm(driver, actions);
		searchpage.clickSearchButton(driver, actions);
	}
}
