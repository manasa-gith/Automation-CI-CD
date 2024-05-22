package mavenPractice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.abstractClass;

public class LandingPage1 extends abstractClass{

	WebDriver driver;
	//Here I have initialized driver. But driver does not have life this is simply a null object. 
	//So i have to get real driver StandAlone.java class which has life globally.
	
	public LandingPage1(WebDriver driver) {
		// TODO Auto-generated constructor stub
	//initializing
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//I have created a constructor to get the real driver from StandAlone.java class. Constructor is the first method to be executed in the class.
	//this.driver = driver; "=driver" is the real driver which is from StandAlone.java class. which has scope with in the constructor.
	//"this.driver"is the local driver which is initialized locally in current class.
		
	//PageFactory
		@FindBy(id ="userEmail")
		private WebElement emailid;
		
		@FindBy(id ="userPassword")
		private WebElement pswd;
		
		@FindBy(id ="login")
		private WebElement submit;
		
		@FindBy(css = "[class*='flyInOut']")
		private WebElement errorMessage;
		
		public ProductCatalogue2 loginApplication(String email, String password)
		{
			emailid.sendKeys(email);
			pswd.sendKeys(password);
			submit.click();
			//After logging in, i am landing on product catalog page. So i will create product catalog object here itself.
			ProductCatalogue2 productCatalogue = new ProductCatalogue2(driver);
			return productCatalogue;
			//This method is returning products list, so return type is product catalogue.
			
			
		}
		
		public String errorMsg()
		{
			waitForWebElementToAppear(errorMessage);
			String errormsg = errorMessage.getText();
			
			return errormsg;
		}
		
		

		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client");
		}
		
	}


