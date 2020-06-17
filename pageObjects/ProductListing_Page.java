package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
 
public class ProductListing_Page extends BaseClass {
	private static WebElement element;
    public ProductListing_Page(WebDriver driver){
    	super(driver);
    	} 

	public static WebElement Select_product() {
		element = null;
       	try{
       		element= driver.findElement(By.xpath("//*[text()=\"Машинка\"]"));
       		Log.info("Category is found");
       	}catch (Exception e){
       		Log.error("Category is not found");
       		
       		throw(e);
       		}
       	return element;
        }
	
	}
	 