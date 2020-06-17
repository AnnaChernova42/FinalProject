package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;
public class EditProfile extends BaseClass {
	private static WebElement element;
	public EditProfile(WebDriver driver) {
		
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static WebElement navigate_to_my_profile(){
	   	 element = null;
	      	try{
	      		element= driver.findElement(By.xpath("//a[@class='_651b68 _8f8823']"));
	      		Log.info("Navigate to my profile button is found on the Home Page");
	      	}catch (Exception e){
	      		Log.error("Continue button on Home page is not found");
	      		throw(e);
	      		}
	      	return element;
	       }
	
	public static WebElement my_profile(){
	   	 element = null;
	      	try{
	      		element= driver.findElement(By.xpath("//a[@class='_651b68 _8f8823']"));
	      		Log.info("Navigate to my profile button is found on the Home Page");
	      	}catch (Exception e){
	      		Log.error("Continue button on Home page is not found");
	      		throw(e);
	      		}
	      	return element;
	       }
	
	
	public static WebElement my_profile_button(){
	   	 element = null;
	      	try{
	      		element= driver.findElement(By.xpath("//a[@class='_651b68 _8f8823']"));
	      		Log.info("Navigate to my profile button is found on the Home Page");
	      	}catch (Exception e){
	      		Log.error("Continue button on Home page is not found");
	      		throw(e);
	      		}
	      	return element;
	       }
	


}
