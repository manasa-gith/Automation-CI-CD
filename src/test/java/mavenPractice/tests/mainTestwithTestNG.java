package mavenPractice.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import mavenPractice.pageObjects.CartPage3;
import mavenPractice.pageObjects.CheckoutPage4;
import mavenPractice.pageObjects.OrderCon6;
import mavenPractice.pageObjects.ProductCatalogue2;
import mavenPractice.pageObjects.orderHistoryPage7;

//THIS MAIN TEST IS CREATED USING TestNG
public class mainTestwithTestNG extends BaseTest {
	String productName = "ADIDAS ORIGINAL";

	@Test(dataProvider = "getData", groups = { "purchase" })
	// public void mainTest(String email, String password, String productName)
	// throws InterruptedException {
	public void mainTest(HashMap<String, String> map) throws InterruptedException {

//		ProductCatalogue2 productCatalogue = landingpage.loginApplication(email, password);
		ProductCatalogue2 productCatalogue = landingpage.loginApplication(map.get("email"), map.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addToCart(map.get("product"));
		CartPage3 cartPage = productCatalogue.goToCartPage();

		// Boolean match = cartPage.verifyProductName(productName);
		Boolean match = cartPage.verifyProductName(map.get("product"));
		Assert.assertTrue(match);
		CheckoutPage4 checkoutPage = cartPage.checkOut();
		checkoutPage.selectCountry("india");
		OrderCon6 confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.ConfirmMsg();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
	// If the above method "mainTest()" is success with order placing then surely
	// order details will be saved in order history.
	// So, I will create another method called "OrderHistoryTest()" method which
	// will verify that product name is displaying in order history page
	// I will verify this using testNG annotation called "dependsonMethods".
	// "dependsonMethods" -> When the second test method wants to be dependent on
	// the first test method, then this could be possible by the use of
	// "dependOnMethods" attribute.
	// If the first test method fails, then the dependent method on the first test
	// method,//i.e., the second test method will not run.

	@Test(dependsOnMethods = { "mainTest" })
	public void OrderHistoryTest() {
		// "ZARA COAT 3";
		ProductCatalogue2 productCatalogue = landingpage.loginApplication("durgatest@gmail.com", "Durga@123");
		// After logging in to website, from i am redirecting from product catalogue
		// page to order history page.
		orderHistoryPage7 orderhistory = productCatalogue.goToOrderPage();
		Assert.assertTrue(orderhistory.verifyOrderDisplay(productName));

	}

	// When we want run the test with 2 different datasets, we can create
	// 2-Dimensional array which accepts multiple data sets.
//	@DataProvider
//	public Object[][] getData() {
//		// Example of 2D array: datatype[][] arrayName = new datatype[rows][columns];
//
//		return new Object[][] { { "durgatest@gmail.com", "Durga@123", "ZARA COAT 3" },
//				                { "manasatest123@gmail.com", "Durga@123", "ADIDAS ORIGINAL" } };

	// If we want to drive the data with more parameters, we can make use of HashMap
	// using dataprovider

	@DataProvider
	public Object[][] getData() throws IOException {

		// Below code is modified code using hashmap
//	HashMap<String,String> hashmap = new HashMap<String, String>();
//	hashmap.put("email", "durgatest@gmail.com");
//	hashmap.put("password", "Durga@123");
//	hashmap.put("product", "ZARA COAT 3");
//    
//    HashMap<String,String> hashmap1 = new HashMap<String, String>();
//    hashmap1.put("email", "manasatest123@gmail.com");
//    hashmap1.put("password", "Durga@123");
//    hashmap1.put("product", "ADIDAS ORIGINAL");

//		 return new Object[][] { { hashmap },
//				{ hashmap1} };

		List<HashMap<String, String>> dataStoring = getJsontoHashmap(
				System.getProperty("user.dir") + "/src/test/java/testdata/data/purchaseOrder.json");

		return new Object[][] { { dataStoring.get(0) }, { dataStoring.get(1) } };

	}

}
