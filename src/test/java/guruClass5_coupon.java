import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class guruClass5_coupon
{
	public static void main(String []args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chrome Driver\\chromedriver.exe");
	    ChromeDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get(" http://live.techpanda.org/index.php/");
	    driver.findElement(By.xpath("//div[@id='header-nav']//child::nav[1]//ol[1]//li[1]//a[1]")).click();
	    List<WebElement> cartProducts = driver.findElements(By.cssSelector("h2.product-name"));
	  
	    for(int i=0;i<cartProducts.size();i++)
	    {
	   String Name = cartProducts.get(i).getText();
	   if(Name.contains("IPHONE"))
	   {
		   driver.findElements(By.xpath("//button[@title='Add to Cart']")).get(i).click();
		   break;
	   }
	    }
 
	    driver.findElement(By.xpath("//input[@id='coupon_code']")).sendKeys("GURU50");
	    driver.findElement(By.xpath("//button[@title='Apply']")).click();
	    System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Coupon code \"GURU50\" was applied.')]")).getText());
}
}
