package appModules;

import pageObjects.ProductListing_Page;

public class CategorySelectAction {
	
	public static void Execute() throws Exception{
		 
		// выбрать категорию товара
     	ProductListing_Page.Select_product().click();

}
}
