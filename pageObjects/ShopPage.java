package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class ShopPage extends BaseClass {
	private static WebElement element;
	public ShopPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public static WebElement Add_button() {
		element = null;
       	try{
       		element= driver.findElement(By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']/div[@class='layout-page desktop']/div[@class='block-vertical']/div[@class='shop-in-shop-container']/div[@class='container new-layout']/div[@class='paginator']/div/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
       		Log.info("Favourite button is found");
       	}catch (Exception e){
       		Log.error("Favourite button is not found");
       		
       		throw(e);
       		}
       	return element;
        }
	
	
	
	public static WebElement search() {
		element = null;
       	try{
       		element= driver.findElement(By.xpath("//div[@class='seller-category-item __item-active']"));
       		Log.info("Shop button is found");
       	}catch (Exception e){
       		Log.error("Shop button is not found");
       		
       		throw(e);
       		}
       	return element;
        }

}
