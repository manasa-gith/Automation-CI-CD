package mavenPractice.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponents.abstractClass;

public class orderHistoryPage7 extends abstractClass {

	WebDriver driver;
	//Here I have initialized driver. But driver does not have life this is simply a null object. 
	//So i have to get real driver StandAlone.java class which has life globally.
	
	//PageFactory
			@FindBy(css = "tr td:nth-child(3)")
		private	List<WebElement> productNames;
		
			
	public orderHistoryPage7(WebDriver driver) {
		// TODO Auto-generated constructor stub
	//initializing
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		
		public Boolean verifyOrderDisplay(String productName)
		{
			Boolean productMatch = productNames.stream().anyMatch(cartproduct ->cartproduct.getText().equalsIgnoreCase(productName));
			return productMatch;
			
		}
		
		
}
		
		
	


