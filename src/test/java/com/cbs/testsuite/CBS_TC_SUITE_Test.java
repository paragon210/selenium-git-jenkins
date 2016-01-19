package com.cbs.testsuite;

import org.testng.annotations.Test;

import page.objects.Cbs_HomepageObject;
import page.objects.Cbs_SearchpageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import utilities.Screenshots;

public class CBS_TC_SUITE_Test extends TestSuiteBase{
	/*private WebDriver driver;
	private Actions actions;
	private WebDriverWait wait;
	private Cbs_HomepageObject homepage;
	private Cbs_SearchpageObject searchpage;
	
	public WebDriver getDriver(){
		return driver;
	}
	//@Parameters("browserType")
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		actions = new Actions(driver);
		wait = new WebDriverWait(driver,30);
		homepage = new Cbs_HomepageObject();
		searchpage = new Cbs_SearchpageObject();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(homepage.getBaseUrl());
	  } */
	  
  @Test(groups = { "regression" }, dependsOnMethods = { "testNav" })
	public void menuItemListsTest() throws InterruptedException{
    List<String> menuListItemsNFL = homepage.getMenuListItemsNFL(); //bring in the list of menus for ease of use
   
     //Use the custom API from the home page class to expose the NFL menu. 
   // wait.until(ExpectedConditions.visibilityOf(homepage.getNavNFL(driver)));
    homepage.moveToNav_nfl(driver,actions);
    wait.until(ExpectedConditions.visibilityOf(homepage.getMenuNFL(driver)));		 
  	for(int i=1; i<= menuListItemsNFL.size();i++)
      {
     	 //WebElement linkText = driver.findElement(By.xpath(".//*[@id='menu_nfl']/ul/li[" + i + "]/a"));
  		 WebElement linkText = homepage.getNflMenuLinks(driver,i);
     	 System.out.println(linkText.getText());
     	 String linkString=linkText.getText();
     	 
     	 //Here we use (i-1) because arraylist starts at 0 while xpath starts at 1.
     	 if(menuListItemsNFL.get(i-1).equals(linkString)) //if(homepage.getMenuListItemsNFL().get(i-1).equals(linkString)) could also be used, but is complicated to read      	 
     	 {
     		 System.out.println("They match!");
     	 }
     	 else
     	 {
     		 System.out.println("Error!");
     	 }
      }              
	}
  
	@Test(groups = { "nightly", "regression" })
    public  void testNav() throws Exception {  
        //Bring in the nav and menu items
        String[] navItems = homepage.getNavItems();
        String[] menuItems = homepage.getMenuItems();
        
        //loop through the nav and menu items and verify them with Assert. 
        for(int i=0;i<navItems.length;i++)
        {
        	homepage.verifyNavHover(actions, driver, navItems[i], homepage);
        	homepage.verifyMenuDisplay(menuItems[i], driver);  	
        }     
    }
 
	/*@Test
	public void searchPageTest(){
		//driver.get(homepage.getBaseUrl());
		
		//Click the search icon on the home page
		wait.until(ExpectedConditions.visibilityOf(homepage.getImgClassElement(driver)));
		homepage.clickSearchIcon(driver, actions);
		
		//Wait for the page to load and the search box to appear. Enter the search term and click the search button.
		//TODO add auto complete check functionality
		wait.until(ExpectedConditions.visibilityOf(homepage.getImgClassElement(driver)));
		searchpage.enterSearchTerm(driver, actions);
		searchpage.clickSearchButton(driver, actions);
		//driver.quit();
		
	} */


  @AfterClass
  public void afterMethod() {
    driver.quit();
  }
  
  @AfterMethod
  public void tearDown(ITestResult testResult) throws IOException{
	  if (testResult.getStatus() == ITestResult.FAILURE){
		  Screenshots.takeScreenshot(driver, testResult.getName());
	  }
  }
  

}
