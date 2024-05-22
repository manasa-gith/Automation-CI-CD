package Cucumber_stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestComponents.BaseTest;
import io.cucumber.java.en.*;
import mavenPractice.pageObjects.CartPage3;
import mavenPractice.pageObjects.CheckoutPage4;
import mavenPractice.pageObjects.LandingPage1;
import mavenPractice.pageObjects.OrderCon6;
import mavenPractice.pageObjects.ProductCatalogue2;

public class stepDefinitions extends BaseTest {

	public LandingPage1 landingPage;
	ProductCatalogue2 productCatalogue;
	CheckoutPage4 checkoutPage;
	OrderCon6 confirmationPage;
	@Given("I landed on Ecommerce page")
	public void i_landed_on_ecommerce_page() throws IOException {
		landingPage = launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String username, String password) {
		productCatalogue = landingpage.loginApplication(username, password);
	}
	
	@When("^I add the product (.+) to the cart$")
	public void i_add_the_product_to_the_cart(String productName) throws InterruptedException {
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addToCart(productName);
	}
	
	//@When("^Checkout product (.+) and submit the order$")
	@And("^Checkout product (.+) and submit the order$")
		public void checkout_product_and_submit_the_order(String productName) {
		CartPage3 cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductName(productName);
		Assert.assertTrue(match);
		checkoutPage = cartPage.checkOut();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();
	}
	
	@Then("{string} message is displayed on confirmation page.")
	public void message_is_displayed_on_confirmation_page(String confMsg) {
		String confirmMessage = confirmationPage.ConfirmMsg();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(confMsg));
		driver.close();
	}
	
	@Then("{string} message is displayed")
	public void message_is_displayed(String incMsg) {
		Assert.assertEquals(incMsg, landingpage.errorMsg());
		driver.close();
	    
	}
	
	
	
}
