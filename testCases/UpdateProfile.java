package testCases;

import org.testng.annotations.Test;

import appModules.SignIn_Action;
import appModules.EditProfile_Action;
import pageObjects.BaseClass;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

import org.testng.annotations.BeforeMethod;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class UpdateProfile {
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
  @Test
  public void main() throws Exception{
	  SignIn_Action.Execute(iTestCaseRow);
	  EditProfile_Action.execute();
	  
  }
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  	DOMConfigurator.configure("log4j.xml");
	  	sTestCaseName = this.toString();
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.startTestCase(sTestCaseName);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		driver = Utils.OpenBrowser(iTestCaseRow);

		new BaseClass(driver);  
      }

  @AfterMethod
  public void afterMethod() {
	    Log.endTestCase(sTestCaseName);
	    driver.close();
		}

}
