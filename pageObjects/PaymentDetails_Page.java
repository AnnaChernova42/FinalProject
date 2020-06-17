package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.Log;

public class PaymentDetails_Page extends BaseClass {
		private static WebElement element;
    
	 public PaymentDetails_Page(WebDriver driver){
   	     super(driver);
   	    }
	public static void scroll() {
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");
	}
	 public static WebElement txt_ZipCode(){
    	 element = null;
       	try{
       		element= driver.findElement(By.name("billZip"));
       		Log.info("ZipCode text box on Payment Details page is found.");
       	}catch (Exception e){
       		Log.error("ZipCode text box on Payment Details page is not found");
       		throw(e);
       		}
       	return element;
        }
	 
	 public static WebElement txt_State(){
    	 element = null;
       	try{
       		element= driver.findElement(By.name("billState"));
       		Log.info("State text box on Payment Details page is found.");
       	}catch (Exception e){
       		Log.error("State text box on Payment Details page is not found");
       		throw(e);
       		}
       	return element;
        }
	 
	 public static WebElement txt_Address(){
    	 element = null;
       	try{
       		element= driver.findElement(By.name("billAddress"));
       		Log.info("Address text box on Payment Details page is found.");
       	}catch (Exception e){
       		Log.error("Address text box on Payment Details page is not found");
       		throw(e);
       		}
       	return element;
        }
	 
	 public static WebElement txt_City(){
    	 element = null;
       	try{
       		element= driver.findElement(By.name("billCity"));
       		Log.info("City text box on Payment Details page is found.");
       	}catch (Exception e){
       		Log.error("City text box on Payment Details page is not found");
       		throw(e);
       		}
       	return element;
        }
	 
	 public static void drpdwn_Country(String sCountry){
    	 element = null;
       	try{
       		Select element= new Select(driver.findElement(By.id("orderBillCountry")));
       		Log.info("Country dropdown on Payment Details page is found.");
       		element.selectByVisibleText(sCountry);
       	}catch (Exception e){
       		Log.error("Country dropdown on Payment Details page is not found");
       		throw(e);
       		}
        }
	 

	 
	 public static WebElement btn_Cancel(){
    	 element = null;
       	try{
       		element= driver.findElement(By.xpath("//*[@id=\"buttons\"]/a[2]"));
       		Log.info("Cancel button on Payment Details page is found.");
       	}catch (Exception e){
       		Log.error("Cancel button on Personal Details page is not found");
       		throw(e);
       		}
       	return element;
        }
	 

}
