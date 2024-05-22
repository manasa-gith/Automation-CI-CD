package mavenPractice.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponents.abstractClass;

public class CartPage3 extends abstractClass {

	WebDriver driver;
	//Here I have initialized driver. But driver does not have life this is simply a null object. 
	//So i have to get real driver StandAlone.java class which has life globally.
	
	public CartPage3(WebDriver driver) {
		// TODO Auto-generated constructor stub
	//initializing
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
		@FindBy(xpath = "//div[@class='cartSection']/h3")
		private	List<WebElement> productTitles;
		@FindBy(xpath = "//li[3][@class='totalRow']/button")
		private WebElement checkoutButton;
		
		
	//GO TO CART PAGE		
		public Boolean verifyProductName(String productName)
		{
			Boolean productMatch = productTitles.stream().anyMatch(cartproduct ->cartproduct.getText().equalsIgnoreCase(productName));
			return productMatch;
			
		}
		
		public CheckoutPage4 checkOut()
		{
			checkoutButton.click();	
			CheckoutPage4 checkout = new CheckoutPage4(driver);
			return checkout;
		}
}
		
		
	


