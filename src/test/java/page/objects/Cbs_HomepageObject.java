package page.objects;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;


 public class Cbs_HomepageObject{
	 


	/**
     * There are hard coded values for testing just as an example.
     * Would really use a data driven solution to store and retrieve this data.
     */
	//private  String baseURL="http://www.espn.com";
	private  String baseURL="http://www.cbssports.com";
    private  String[] navItems = {"nav_nfl","nav_nba","nav_nhl"};
    private  String[] menuItems = {"menu_nfl","menu_nba","menu_nhl"}; //
    private  List<String>menuLinkTextNFL = Arrays.asList("NFL Home","Scores","Playoff Bracket","Schedule","Standings","Stats","Teams","Players","Transactions","Injuries",
    		"Expert Picks","Prisco's Picks","Power Rankings","Odds","Super Bowl","Draft","Tickets","GMC Perfect Season");
    private  String navAttr = "navHover"; //the name of the class attribute populated when nav item is hovered over
	private String href = "http://www.cbssports.com/info/search";
	private String altText = "Search CBSSports.com";
	private String imgClass = "globalSearchIcon";

    
    public   WebElement element = null;
    
    //@FindBy(xpath="//div[@class='globalNavMenu']/ul")
    //WebElement menuItemLinks;
    

	//private WebDriver driver;
    
	/**
	 * Constructor 
	 * @param driver
	 */
    //public Cbs_HomepageObject(WebDriver driver){
    //	this.driver = driver;
    	//PageFactory.initElements(driver, this);
    //}
    
    /**
     * Returns the NFL Menu id 
     * @param driver
     * @return
     */
    public WebElement getMenuNFL(WebDriver driver){
    	element = driver.findElement(By.id("menu_nfl"));
    	return element;
    }
    
    /**
     * Returns the NFL nav id
     * @param driver
     * @return
     */
    public WebElement getNavNFL(WebDriver driver){
    	element = driver.findElement(By.id("nav_nfl"));
    	return element;
    }
    
    /**
     * Returns the list of items Li items under the NFL menu
     * @param navItem
     * @return
     */
    public List<WebElement> getNavItemListItems(WebDriver driver, String navItem){
    	List<WebElement> elements = driver.findElements(By.xpath(".//*[@id=" + "'" + getMenuNFL(driver) + "']/ul/li"));
    	return elements;
    }
    
    /**
     * Returns a list of links from the NFL Menu drop down
     * @param index
     * @return
     */
    public WebElement getNflMenuLinks(WebDriver driver, int index){
    	WebElement linkText = driver.findElement(By.xpath(".//*[@id='menu_nfl']/ul/li[" + index + "]/a"));
    	return linkText;
    }
    
    /**
     * Returns the menu links located under the appropriate class
     * @param driver
     * @return
     */
	 public  WebElement menuItemLinks(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='globalNavMenu']/ul"));
	    return element;
	    }
	 
	 /**
	  * Returns the class attribute from a main navigation item
	  * @param driver
	  * @param navItem
	  * @return
	  */
	 public  String getClassAttrFromNavItem (WebDriver driver, String navItem){	 
		String classAttr = driver.findElement(By.xpath(".//*[@id=" + "'" + navItem + "']" )).getAttribute("class");
	    return classAttr;
	 }
	 
	 /**
	  * Move to navigation id for NFL
	  * @param actions
	  * @return
	 * @throws InterruptedException 
	  */
	 public void  moveToNav_nfl (WebDriver driver, Actions actions) throws InterruptedException{    
	    actions.moveToElement(getNavNFL(driver)).perform();
	 }
	 
	 /**
	  * Move to NFL menu
	  * @param actions
	  * @throws InterruptedException
	  */
	 public  void hoverOnNFLMenu(WebDriver driver, Actions actions) throws InterruptedException{ 
		 actions.moveToElement(getMenuNFL(driver)).perform();	 
	 }
	 
	 /**
	  * Returns the hard coded navigation items
	  * @return
	  */
	 public  String[] getNavItems (){
		 return navItems;
	}
	 
	 /**
	  * Returns the hard coded menu items
	  * @return
	  */
	 public  String[] getMenuItems (){	 
		 return menuItems;	 
	}
	 
	 /**
	  * Returns the menu text of the NFL list
	  * @return
	  */
	 public  List<String> getMenuListItemsNFL(){
		 return menuLinkTextNFL;
	 }
	 
	/**
	 * Returns the class attribute activated on mouse hover
	 * @return
	 */
	 public  String getNavigationAttrForHover(){
		 return navAttr;
	 }
	 
	 /**
	  * Returns the base url of the home page
	  * @return
	  */
	 public  String getBaseUrl(){
		 return baseURL;
	 }
	
	 /**
	  * Find and click the search icon
	  * @param driver
	  * @param actions
	  */
	public void clickSearchIcon(WebDriver driver, Actions actions){
		WebElement element = driver.findElement(By.className(getImgClass()));
		actions.moveToElement(element).click().build().perform();			
	}
	
	/**
	 * Returns the link text of the search link
	 * @return
	 */
	public String getHrefText(){
		return href;
	}
	
	/**
	 * Returns the alternate text of the search link
	 * @return
	 */
	public String getAltTxt(){
		return altText;
	}
	
	/**
	 * Return the image class as a string
	 * @return
	 */
	public String getImgClass(){
		return imgClass;
	}
	
	/**
	 * Return the class name as a WebElement
	 * @param driver
	 * @return
	 */
	public WebElement getImgClassElement(WebDriver driver){
		element = driver.findElement(By.className(getImgClass()));
		return element;
	}
	
	/**
	 * Verify the nav hover attribute
	 * @param driver
	 * @param actions
	 */
	public  void verifyNavHover(Actions actions, WebDriver driver, String navItem, Cbs_HomepageObject homepage) throws InterruptedException
	  {
	  	WebElement mainElementToVerify=driver.findElement(By.id(navItem));
	  	actions.moveToElement(mainElementToVerify).perform();
	  	Thread.sleep(6000);  //TODO change to a wait.until	
	  	Assert.assertEquals(homepage.getNavigationAttrForHover(), homepage.getClassAttrFromNavItem(driver, navItem));
	  	Reporter.log("Verifying the actual value with the expected value", true);
	  	Reporter.log("");
	 
	  }
	  
	/**
	 * Verify the menu is displayed
	 * @param driver
	 * @param actions
	 */
	  public  void verifyMenuDisplay(String menuItem, WebDriver driver)
	  {
	  	WebElement displayElementToVerify=driver.findElement(By.id(menuItem));
	  	
	  	boolean res = displayElementToVerify.isDisplayed();
	  	if(!res)
	  	{
	  		System.out.println("Element " + menuItem + " is not displayed");
	  	}
	  	else
	  	{
	  		System.out.println( menuItem + ": " + res); //as a debug
	  	}
	  }
	

	

}
