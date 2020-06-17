package appModules;

import org.testng.Reporter;

import pageObjects.PaymentDetails_Page;
import utility.Log;

public class PaymentDetails_Action {
	
	// iTestcaseRow -номер тесткейса в ексель файле
	public static void execute(int iTestCaseRow) throws Exception{
		try{
  			
			// Очистить предустановленные значения
			PaymentDetails_Page.txt_ZipCode().clear();
   			PaymentDetails_Page.txt_ZipCode().sendKeys("109559");
			
			PaymentDetails_Page.txt_State().clear();
			PaymentDetails_Page.txt_State().sendKeys("Moscow");
			Log.info(" State is entered on the Payment detail page");
			
			PaymentDetails_Page.txt_Address().clear();
			PaymentDetails_Page.txt_Address().sendKeys("str Tverskaya");
			Log.info( "Address is entered on the Payment detail page");
		
			
			PaymentDetails_Page.txt_City().clear();
			PaymentDetails_Page.txt_City().sendKeys("MOSCOW");
			Log.info("City is entered on the Payment detail page");
			
			PaymentDetails_Page.drpdwn_Country("RUSSIA");
			Log.info(" Country is Selected on the Payment detail page");
			
		
			PaymentDetails_Page.scroll();
			// Нажать Отмена
			PaymentDetails_Page.btn_Cancel().click();
			Log.info("Click action is performed on cancel button on the Payment detail page");
			
            
			Reporter.log("Payment is cancelled.");
			
	    }catch(Exception e){
			throw(e);
			}
		}
}
