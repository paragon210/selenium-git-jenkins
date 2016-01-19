package com.cbs.testsuite;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import page.objects.Cbs_HomepageObject;
import page.objects.Cbs_SearchpageObject;

public class TestSuiteBase {
	protected WebDriver driver;
	protected Actions actions;
	protected WebDriverWait wait;
	protected Cbs_HomepageObject homepage;
	protected Cbs_SearchpageObject searchpage;
	
	@BeforeClass(alwaysRun=true)
	public void setUp(){
		driver = new FirefoxDriver();
		actions = new Actions(driver);
		wait = new WebDriverWait(driver,30);
		homepage = new Cbs_HomepageObject();
		searchpage = new Cbs_SearchpageObject();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(homepage.getBaseUrl());
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
}
