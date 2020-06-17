package appModules;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
     
    public class SignIn_Action  extends BaseClass {
    	
        
        public SignIn_Action(WebDriver driver){
            	super(driver);
        }    
        public static void Execute(int iTestCaseRow) throws Exception{
        	
        	// Нажать ссылку "моя аккаунт
        Log.info("Click action is perfromed on My Account link" );
        	
        	// Считать значение логина из ексель
        	// iTestcaseRow содержит номер нашего тесткейса из листа с данными
        	// Constant.Col_UserName номер колонки для логина
        driver.findElement(By.linkText("Log In")).click();
        try {
      		Thread.sleep(1000);
      	} catch (InterruptedException e) {
      		e.printStackTrace();
      	}

        
        	String sUserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_UserName);
        	// Ввод логина
        	Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.id("inputName")));
            actions.click();
            actions.sendKeys(sUserName);
            actions.build().perform();
            
            // Запись в лог выполненного действия
            Log.info(sUserName+" is entered in UserName text box" );
            
            String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Password);
            System.out.println(sPassword);
            actions.moveToElement(driver.findElement(By.id("pwd1")));
            actions.click();
            actions.sendKeys("12345678");
            actions.build().perform();
            actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"signinForm\"]/div[4]/button")));
            actions.click();
            actions.build().perform();
            Log.info("Click action is performed on Submit button");
            
            // Ожидание 10 secs перед следующим шагом
            try {
          		Thread.sleep(2000);
          	} catch (InterruptedException e) {
          		e.printStackTrace();
          	}
            Utils.waitForElement(Home_Page.SearchBar());
            
            // Другой вариант логирования с помощью TestNg Reporter log
            // Сюда пишем только очень важные сообщения, т к они появятся в TestNG HTML отчете
            Reporter.log("SignIn Action is successfully perfomred");
            
        }
    }
