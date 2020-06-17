package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.ProductListing_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import appModules.CheckOut_Action;
import appModules.SignIn_Action;

public class ExploreProducts{
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
  // пререквизиты тест-кейса
  @BeforeMethod
  public void beforeMethod() throws Exception {
	    // конфигурируем лог
	  	DOMConfigurator.configure("log4j.xml");
	  	
	  	// Получаем имя тесткейса
	  	sTestCaseName = this.toString();
	  	// чистим имя тест-кейса
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
	  	
	  	
	  	// пишем в лог имя тест-кейса
		Log.startTestCase(sTestCaseName);
		
		// подгружаем ексель
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		
		// находим номер строки с нашим тесткейсом
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		// запускаем браузер
		driver = Utils.OpenBrowser(iTestCaseRow);

		new BaseClass(driver);  
        }
  
  // собственно, тест-кейс
  @Test
  public void main() throws Exception {
	  try{
		 
		SignIn_Action.Execute(iTestCaseRow);
		Home_Page.SearchBar().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Course));
		Home_Page.SearchBar().sendKeys(Keys.ENTER);
		Log.info("Searching for product");
		Utils.waitForElement(Home_Page.SearchBar());
		Thread.sleep(2000);
		WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='Искать в Магазине']"));
		usernameField.click();
		Thread.sleep(2000);
		String Search = usernameField.getAttribute("data-original-title");
		
		System.out.println(Search);
		if(Search.contains("Add to wishlist")){
			usernameField.click();
	    }
		driver.findElement(By.xpath("//div[@class='context-chip m-all-contexts']")).click();
		driver.findElement(By.xpath("//div[@class='_1f0382']//div[3]//div[2]")).click();
		Thread.sleep(2000);
		ProductListing_Page.Select_product().click();
		Utils.waitForElement(Home_Page.AddButton());
		Home_Page.AddButton().click();
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");

		CheckOut_Action.Execute();
		
		
		
		// проверяем, все ли проверки выполнены  успешно
		if(BaseClass.bResult==true){
			// если значение true, то все проверки выполнены успешно
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
		}else{
			// есть ошибки
			throw new Exception("Test Case Failed because of Verification");
		}
		
	  // Шаги, которые будут полезны в случае неуспешно завершенного теста
	  }catch (Exception e){
		  // в случае наличия любого exception тест будет помечен как непройденный
		  ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
		  Utils.takeScreenshot(driver, sTestCaseName);
		  Log.error(e.getMessage());
		  // повторно выбрасываем ошибку, что б пометить тест непройденным в отчете TestNG
		  throw (e);
	  }
		
  }

  @AfterMethod
  public void afterMethod() {
	    Log.endTestCase(sTestCaseName);
	    driver.close();
  		}

}
