package mavenPractice.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import mavenPractice.pageObjects.CartPage3;
import mavenPractice.pageObjects.CheckoutPage4;
import mavenPractice.pageObjects.LandingPage1;
import mavenPractice.pageObjects.OrderCon6;
import mavenPractice.pageObjects.ProductCatalogue2;

//THIS MAIN TEST IS CREATED USING PAGEOBJECT MODEL

public class mainTestPOM {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		WebDriverWait wait = new 	WebDriverWait(driver, Duration.ofSeconds(10));
		
	//LANDINGPAGE
		LandingPage1 landingpage = new LandingPage1(driver);
		//For pagefactory
		landingpage.goTo();
		ProductCatalogue2 productCatalogue = landingpage.loginApplication("durgatest@gmail.com", "Durga@123");
		
	//PRODUCT CATALOGUE
		List<WebElement> products = productCatalogue.getProductList();
		String productName = "ADIDAS ORIGINAL";
		productCatalogue.addToCart(productName);
		CartPage3 cartPage = productCatalogue.goToCartPage();
		
	//REDIRECTING TO CART PAGE	
		
		Boolean match = cartPage.verifyProductName(productName);
		Assert.assertTrue(match);
		CheckoutPage4 checkout = cartPage.checkOut();
	//CHECKOUT PAGE
		String countryName = "India";
		checkout.selectCountry(countryName);
		OrderCon6 orderconfirm = checkout.submitOrder();
		
		

	//ORDER CONFIRMATION PAGE
		 
		 String ordermsg = orderconfirm.ConfirmMsg();
		 Assert.assertTrue(ordermsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		System.out.println("Successfully executed the application regarding order placing");
}
}




