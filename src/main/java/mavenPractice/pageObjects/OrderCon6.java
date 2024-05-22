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

public class OrderCon6 extends abstractClass {

	WebDriver driver;
	//Here I have initialized driver. But driver does not have life this is simply a null object. 
	//So i have to get real driver StandAlone.java class which has life globally.
	
	public OrderCon6(WebDriver driver) {
		// TODO Auto-generated constructor stub
	//initializing
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	//PageFactory
		
		@FindBy(xpath = "//h1[contains(text(),'Thankyou for the order.')]")
		private WebElement ConfirmMsg;
		
			
		public String ConfirmMsg()
		{
			
			String message = ConfirmMsg.getText();
			return message;
		}
		
		}
	


