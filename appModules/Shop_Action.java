package appModules;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.BaseClass;
import pageObjects.BlogsPage;


public class Shop_Action extends BaseClass {
	private static WebElement element;
	
public Shop_Action(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

public static void Execute() throws Exception{ 
     	
	ShopPage.Favourite_button().click();
	WebDriverWait waitElement = new WebDriverWait(driver,30);
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	//используем хендлеры для переключения между окнами
	String handleName = tabs.get(1);
    driver.switchTo().window(handleName);
    //найти товар

    ShopPage.search().sendKeys("Машина");
    ShopPage.search().sendKeys(Keys.ENTER);
    waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"searchresults\"]")));
    String Search = driver.findElement(By.id("search-tag-name")).getText();
    System.out.println(Search);
    if(Search.equals("Машина")) {
    	System.out.println("The search is filtered for Машина");
    }
    Thread.sleep(2000);
    //добавить маганиз в избранное
    driver.findElement(By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']/div[@class='layout-page desktop']/div[@class='block-vertical']/div[@class='shop-in-shop-container']/div[@class='container new-layout']/div[@class='paginator']/div/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).click();
    waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']/div[@class='layout-page desktop']/div[@class='block-vertical']/div[@class='shop-in-shop-container']/div[@class='container new-layout']/div[@class='paginator']/div/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")));

	 }


}
