package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appModules.SignIn_Action;
import pageObjects.BaseClass;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class ExploreShops {
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
  @Test
  public void main() throws Exception{
	  SignIn_Action.Execute(iTestCaseRow);
	  driver.findElement(By.xpath("//header[@class='cf3b48']//li[4]//a[1]")).click();
	  driver.findElement(By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']/div[@class='layout-page desktop']/div[@class='block-vertical']/div[@class='shop-in-shop-container']/div[@class='container new-layout']/div[@class='paginator']/div/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]")).click();
	  Thread.sleep(2000);
	  if(driver.getPageSource().contains("Все товары")){
	        System.out.println("Goods are loaded");
	    }
	  driver.findElement(By.xpath("//a[@class='__button']")).click();
	  driver.findElement(By.xpath("//a[@class='__link']")).click();

  }
  
  @BeforeMethod
  public void beforeMethod() throws Exception {
	// Конфигурируем Log4j
	  	DOMConfigurator.configure("log4j.xml");
	  	
	  	// получаем номер тесткейса
	  	sTestCaseName = this.toString();
	  	// приводим название тесткейса к нормальному виду
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
	  	
	  	
	  	// записываем название кейса в лог
		Log.startTestCase(sTestCaseName);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		
		// Находим номер тест-кейса в екселе
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		// запускаем браузер
		driver = Utils.OpenBrowser(iTestCaseRow);
		
		// инициируем базовый класс
		new BaseClass(driver);  
      }

  @AfterMethod
  public void afterMethod() {
	    Log.endTestCase(sTestCaseName);
	    driver.quit();
		}
}
