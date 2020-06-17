package testCases;


import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appModules.BlogPage_Action;
import appModules.SignIn_Action;
import pageObjects.BaseClass;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class ExploreCategory {
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
  @Test
  public void main() throws Exception{
	  SignIn_Action.Execute(iTestCaseRow);
	  WebDriverWait waitElement = new WebDriverWait(driver,30);
      waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']/div[@class='layout-page desktop']/div[@class='block-vertical']/div[@class='container']/div[13]/div[1]/div[1]/a[1]")));
      ShopPage_Action.Execute();
      
	    
  }
  @BeforeMethod
  public void beforeMethod() throws Exception {
	// Конфигурируем логи Log4j
	  	DOMConfigurator.configure("log4j.xml");
	  	
	  	// Получаем имя тест-кейса
	  	sTestCaseName = this.toString();
	  	// в предыдущем методе мы получили длинное название, включающее название класса
	  	// приведем его к нормальному виду
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
	  	
	  	
	  	// запишем в лог название теста
		Log.startTestCase(sTestCaseName);
		
		// подгрузим ексель
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		
		// найдем номер строки ,соответствующей нашему кейсу
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		// запускаем браузер
		driver = Utils.OpenBrowser(iTestCaseRow);
		
		// инициируем базовый класс
		new BaseClass(driver);  
      }

  @AfterMethod
  public void afterMethod() {
	    // выводим логи
	    Log.endTestCase(sTestCaseName);
	    // закрываем браузер
	    driver.quit();
		}
}
