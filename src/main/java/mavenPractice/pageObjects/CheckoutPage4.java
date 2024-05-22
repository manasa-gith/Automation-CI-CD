package mavenPractice.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import abstractComponents.abstractClass;

public class CheckoutPage4 extends abstractClass {

	WebDriver driver;
	//Here I have initialized driver. But driver does not have life this is simply a null object. 
	//So i have to get real driver StandAlone.java class which has life globally.
	
	public CheckoutPage4(WebDriver driver) {
		// TODO Auto-generated constructor stub
	//initializing
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
		
		@FindBy(xpath = ("//input[@placeholder='Select Country']"))
		private WebElement Option;
		By optionResults = By.cssSelector(".ta-results");
		@FindBy(xpath = ("//button[contains(@class,'ta-item')][2]"))
		private WebElement countryOption;
		@FindBy(xpath = ("//a[contains(text(),'Place Order')]"))
			//	@FindBy(css = "//button("a.action__submit")"
		private WebElement placeOrder;
	//GO TO CART PAGE		
		
		public void selectCountry(String countryName)
		{
			//waitForWebElementToAppear(Option);
			Actions a = new Actions(driver);
			//a.moveToElement(Option).click();
			a.sendKeys(Option, countryName).build().perform();
			waitForElementToAppear(optionResults);
			countryOption.click();
		}
		
		
		
		public OrderCon6 submitOrder()
		{
//			Actions action = new Actions(driver); 
//			action.moveToElement(placeOrder).build().perform();
			//waitForWebElementToAppear(placeOrder);
			placeOrder.click();
			OrderCon6 orderconfirm = new OrderCon6(driver);
			return orderconfirm;
		}
		
		}
	


