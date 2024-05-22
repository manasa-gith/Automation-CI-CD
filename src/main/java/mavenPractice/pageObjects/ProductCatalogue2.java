package mavenPractice.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.abstractClass;

public class ProductCatalogue2 extends abstractClass {

	WebDriver driver;
	//Here I have initialized driver. But driver does not have life this is simply a null object. 
	//So i have to get real driver from StandAlone.java class which has life globally.
	
	public ProductCatalogue2(WebDriver driver) {
		// TODO Auto-generated constructor stub
	//initializing
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
		@FindBy(css =".mb-3")
		private List<WebElement> products;
		By listOfProducts = By.cssSelector(".mb-3");
		By AddToCart = By.cssSelector(".card-body button:last-of-type");
		By ToastMsg = By.cssSelector("#toast-container");
	
		@FindBy(css=".ng-animating")
		WebElement loader;
		
		
	//TO GET LIST OF PRODUCTS		
		public List<WebElement> getProductList()
		{
			waitForElementToAppear(listOfProducts);
			
			return products;
		}

	//TO GET PRODUCT NAME	
		public WebElement getProductName(String productName)
		{
		WebElement prod = getProductList().stream().filter(product->product.findElement(By.cssSelector("b"))
				                            .getText().equals(productName)).findFirst().orElse(null);
		
		return prod;
		}
	
	//ADD PRODUCT TO CART
		public void addToCart(String productName) throws InterruptedException
		{
		WebElement prod = getProductName(productName);
				prod.findElement(AddToCart).click();
				waitForElementToAppear(ToastMsg);
				waitforElementtoDisappear(loader);
		}
	

		
	}


