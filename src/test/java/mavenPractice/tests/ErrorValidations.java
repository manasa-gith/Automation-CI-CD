package mavenPractice.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import TestComponents.Retry;
import mavenPractice.pageObjects.CartPage3;
import mavenPractice.pageObjects.ProductCatalogue2;

public class ErrorValidations extends BaseTest
{
@Test(groups = {"ErrorHandling"}, retryAnalyzer=Retry.class) 
                   					//If we want to rerun this test if it is failed, in that case i can mention to the method like retryAnalyzer= classname(Retry.class)
public  void loginErrorValidation()
	{
		landingpage.loginApplication("durgatest@gmail.com", "durg@123");
		
		Assert.assertEquals("Incorrect email or password.", landingpage.errorMsg());
		
	}

@Test
public void productErrorValidation() throws InterruptedException
{
	ProductCatalogue2 productCatalogue = landingpage.loginApplication("manasatest123@gmail.com", "Durga@123");
			List<WebElement> products = productCatalogue.getProductList();
		String productName = "IPHONE 13 PRO";
		productCatalogue.addToCart(productName);
		CartPage3 cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductName("IPHONE 13 P");
	Assert.assertFalse(match);
	
}
	
	
	
}
