package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

public class Cbs_SearchpageObject {

	/**
	 * Hard coded variables we will check for and use.
	 */
	private String href = "http://www.cbssports.com/info/search";
	private String altText = "Search CBSSports.com";
	private String imgClass = "globalSearchIcon";
	private String searchTerm = "LeBron";
	
	/**
	 * Return the link text string of the search link
	 * @return
	 */
	public String getHrefText(){
		return href;
	}
	
	/**
	 * Return the alternate text of the search image
	 * @return
	 */
	public String getAltTxt(){
		return altText;
	}
	
	/**
	 * Return the image class string
	 * @return
	 */
	public String getImgclass(){
		return imgClass;
	}
	
	/**
	 * Returm the search term string
	 * @return
	 */
	public String getSearchTerm(){
		return searchTerm;
	}
	
	/**
	 * Find the search box
	 * @param driver
	 * @return
	 */
	public WebElement getSearchBox(WebDriver driver){
		WebElement element = driver.findElement(By.name("query"));
		return element;
	}
	
	/**
	 * Find the search box and enter the search term using sendKeys and calling getSearchTerm
	 * @param driver
	 * @param actions
	 */
	public void enterSearchTerm(WebDriver driver, Actions actions){
		WebElement inputId = driver.findElement(By.id("query"));
		inputId.sendKeys(getSearchTerm());
	}
	
	/**
	 * Find and click the Search button on the page
	 * @param driver
	 * @param actions
	 */
	public void clickSearchButton(WebDriver driver, Actions actions){
		WebElement button = driver.findElement(By.name("Search"));
		button.click();
	}
	
	


}
