package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class CheckOut_Page extends BaseClass{
		private static WebElement element;
     public CheckOut_Page(WebDriver driver){
    	super(driver);
    	}
	 
	 public static WebElement btn_Continue(){
    	 element = null;
       	try{
       		element= driver.findElement(By.xpath("//*[@id=\"cddccard\"]/div[2]/button"));
       		Log.info("Continue button is found on the Check Out Page");
       	}catch (Exception e){
       		Log.error("Continue button on Check Out page is not found");
       		throw(e);
       		}
       	return element;
        }
}
