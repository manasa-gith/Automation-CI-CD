import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class guruClass2_AddtoWishlist 
{
	public static void main(String []args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chrome Driver\\chromedriver.exe");
	    ChromeDriver driver = new ChromeDriver();
	    String[] names = {"LG LCD"};
	    //System.setProperty("webdriver.edge.driver", "D:\\Selenium\\Edge Driver\\msedgedriver.exe");
		//WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
	    //DAY1
	   driver.get(" http://live.techpanda.org/index.php/");
	   driver.findElement(By.xpath("//*[@class='footer']//child::div[4]/ul[1]/li[1]/a[1]")).click();
	  driver.findElement(By.xpath("//*[@class='col2-set']//child::div[1]/div[2]/a[1]")).click();
	  driver.findElement(By.id("firstname")).sendKeys("wishistsharing");
	  driver.findElement(By.id("lastname")).sendKeys("te");
	  driver.findElement(By.name("email")).sendKeys("wishlisttest09865@gmail.com");
	  driver.findElement(By.name("password")).sendKeys("qwertyuiop");
	  driver.findElement(By.name("confirmation")).sendKeys("qwertyuiop");
	  driver.findElement(By.xpath("//button[@title='Register']")).click();
	  System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Thank you for registering with Main Website Store.')]")).getText());
	  
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='header-nav']//child::nav[1]/ol[1]/li[2]/a[1]")).click();
	  
	  //To click on Add to wishlist button, same button is present for multiple products.So i have created for loop here if there are more products are added in the page, it would be easier to run the same code.
	  List<WebElement> products = driver.findElements(By.cssSelector("h2.product-name"));
	  for(int i=0;i<products.size();i++)
	  {
		  String name = products.get(i).getText();
		  if(name.contains("LG LCD"))
		  {
			  //Add to wishlist
			  driver.findElements(By.className("link-wishlist")).get(i).click();
			  break;
		  }
		  
	  }
	  driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]")).click();
	 driver.findElement(By.xpath("//textarea[@id='email_address']")).sendKeys("email0876@gmail.com");
	 driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Hello, code successfully executed.");
	 driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]")).click();
	 System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Your Wishlist has been shared.')]")).getText());
	 
	  
	  
}
}
