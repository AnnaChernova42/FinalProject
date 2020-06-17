package pageObjects;
        import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
    public class Home_Page extends BaseClass{
            private static WebElement element = null;
           
        public Home_Page(WebDriver driver){
            	super(driver);
        }    
        
        
        public static WebElement SearchBar() throws Exception{
            try{ 
	        	 element = driver.findElement(By.xpath("//input[@placeholder='Искать на Ozon']"));
	             Log.info("Search Button is found");
            }catch (Exception e){
           		Log.error("Search Button is not found");
           		throw(e);
           		}
           	return element;
        }
        

        
        public static WebElement EnterButton() throws Exception{
        	
        	try{ 
	        	 element = driver.findElement(By.xpath("//div[@class='_651b68 _8f8823']"));
	             Log.info("Enter button is found");
           }catch (Exception e){
          		Log.error("Enter button is not found");
          		throw(e);
          		}
          	return element;
        }
        
      
    }
