import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class guruClass1_4DaysCodeIncluded 
{
	public static void main(String []args)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chrome Driver\\chromedriver.exe");
	    ChromeDriver driver = new ChromeDriver();
	    //System.setProperty("webdriver.edge.driver", "D:\\Selenium\\Edge Driver\\msedgedriver.exe");
		//WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
	    //DAY1
	   driver.get(" http://live.techpanda.org/index.php/");
	   driver.findElement(By.linkText("MOBILE")).click();
       System.out.println(driver.findElement(By.xpath("//h1[text()='Mobile']")).getText());
       Select drpdown = new Select(driver.findElement(By.cssSelector("select[title='Sort By']")));
       //drpdown.selectByIndex(1);
       drpdown.selectByVisibleText("Name");
       
       //DAY2
       //String xpediaPrice = driver.findElement(By.id("product-price-1")).getText();
       //driver.findElement(By.cssSelector("a[title='Sony Xperia']")).click();
       //String xpediaDetailprc = driver.findElement(By.id("product-price-1")).getText();
       //Assert.assertEquals(xpediaPrice,xpediaDetailprc);
       //System.out.println("List and details page of sony xperia exists with same price $100");
       
       //DAY3
       //Parent to child element syntax: Xpath =//*[@id='java_technologies']//child::li[1]
       //Below line of code is child element syntax.To click on 'Add to cart' button for Sony xperia mobile.
//       driver.findElement(By.xpath("//*[@class='category-products']//child::li[3]/div/div[3]/button")).click();			   
//       System.out.println(driver.findElement(By.className("success-msg")).getText());
//       driver.findElement(By.xpath("//*[@class='first last odd']//child::td[4]/input")).clear();
//       driver.findElement(By.xpath("//*[@class='first last odd']//child::td[4]/input")).sendKeys("1000");
//       driver.findElement(By.xpath("//*[@class='first last odd']//child::td[4]/button")).click();
//       System.out.println(driver.findElement(By.className("item-msg")).getText());
//       driver.findElement(By.xpath("//button[@id='empty_cart_button']")).click();
//       System.out.println(driver.findElement(By.className("main")).getText());
       
       //DAY4
       driver.findElement(By.xpath("//*[@class='category-products']//child::li[1]/div[1]/div[3]/ul[1]/li[2]/a[1]")).click();
       System.out.println(driver.findElement(By.xpath("//span[contains(text(),'The product IPhone has been added to comparison list.')]")).getText());
       driver.findElement(By.xpath("//*[@class='category-products']//child::li[2]/div[1]/div[3]/ul[1]/li[2]/a[1]")).click();
       System.out.println(driver.findElement(By.xpath("//span[contains(text(),'The product Samsung Galaxy has been added to comparison list.')]")).getText());
       driver.findElement(By.xpath("//button[@title='Compare']")).click();
       //System.out.println(driver.getWindowHandles().size());
       Set<String> windows=driver.getWindowHandles();
       Iterator<String> itr=windows.iterator();
       String parentwindow=itr.next();
       String childwindow=itr.next();
       driver.switchTo().window(childwindow);
       System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Compare Products')]")).getText());
       driver.manage().window().maximize();
       System.out.println(driver.findElement(By.xpath("//div[contains(text(),'IPhone is the one of the best mobile device in mar')]")).getText());
       System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Samsung Galaxy is a great phone by samsung')]")).getText());
       driver.findElement(By.xpath("//button[@title='Close Window']")).click();
	    	
	}
}

