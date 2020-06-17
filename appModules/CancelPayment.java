package appModules;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import pageObjects.BaseClass;

public class CancelPayment extends BaseClass{
	public CancelPayment(WebDriver driver){
    	super(driver);
}    
	
	public static void Execute() throws Exception{ 
     	
     	// Нажать Отменить на странице оформления заказа
		Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("reasonRadio6")));
        actions.click();
        actions.build().perform();
        actions.moveToElement(driver.findElement(By.xpath("//*[text()=\"Cancel Transaction\"]")));
        actions.click();
        actions.build().perform();
	 }

}
