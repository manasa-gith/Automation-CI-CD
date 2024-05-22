package abstractComponents;
//AbstarctComponents package is created for reusable code. Segregating the reusable code here.

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mavenPractice.pageObjects.CartPage3;
import mavenPractice.pageObjects.orderHistoryPage7;

public class abstractClass {

	WebDriver driver;
	public abstractClass(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[routerlink*='cart']") 
	WebElement cartHeader;
	@FindBy(css="[routerlink*='myorders']") 
	WebElement orderHeader;
	
	public void waitForElementToAppear(By findBy)
	{
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)) ;
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)) ;
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitforElementtoDisappear(WebElement elem) throws InterruptedException
	{
		
		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)) ;
//		wait.until(ExpectedConditions.invisibilityOf(elem));
	}
	
	
	//cart option is in header in which header section is reusable, mentioned this in abstract class.
	public CartPage3 goToCartPage()
	{
		cartHeader.click();
		
		CartPage3 cartPage = new CartPage3(driver);
		return cartPage;
		//This method is landing on cart page, so page object of cart page is created here itself.Return type is cart page.
	}
	
	public orderHistoryPage7 goToOrderPage()
	{
		orderHeader.click();
		
		orderHistoryPage7 orderhistory = new orderHistoryPage7(driver);
		return orderhistory;
		//This method is landing on cart page, so page object of cart page is created here itself.Return type is cart page.
	}
	
	
}
