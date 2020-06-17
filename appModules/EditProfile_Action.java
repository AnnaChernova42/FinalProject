package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.BaseClass;
import pageObjects.EditProfile;
import utility.Log;

public class EditProfile_Action extends BaseClass {
	
	public EditProfile_Action(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

		// iTestcaseRow -номер строки в ексель для нашего тесткейса

		public static void execute() throws Exception{
			try{
				
				EditProfile.navigate_to_my_profile().click();
				Log.info("Navgating to my profile page");
				EditProfile.my_profile().click();
				Log.info("CLick on edit personal info ");
				WebDriverWait waitElement = new WebDriverWait(driver,20);
				waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']/div[@class='layout-page desktop']/div[@class='block-vertical']/div[@class='container']/div[@class='row']/div[@class='column']/div[@class='my-page-content column__item_remove-margin']/div[@class='settings']/a[1]")));
				EditProfile.my_profile_button().click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@class='container m-filled m-gray m-material input m-long input-fullName']//input[@class='input m-gray m-material']")).clear();
				driver.findElement(By.xpath("//div[@class='container m-filled m-gray m-material input m-long input-fullName']//input[@class='input m-gray m-material']")).sendKeys("Вася Пупкин");
				driver.findElement(By.xpath("//label[2]//input[1]")).click();
				// сохранить
				driver.findElement(By.xpath("//button[@class='save button blue large m-material']")).click();

			}catch(Exception e){
				throw(e);
				}

		}
}
