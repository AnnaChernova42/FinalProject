package appModules;


import pageObjects.CheckOut_Page;

public class CheckOut_Action {
	 public static void Execute() throws Exception{ 
     	
     	// Clicking on the Continue button on the Check Out page
		Thread.sleep(2000);
     	CheckOut_Page.btn_Continue().click();
	 }

}
