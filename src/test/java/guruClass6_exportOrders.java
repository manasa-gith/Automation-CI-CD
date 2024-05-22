import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class guruClass6_exportOrders {
	public static void main(String []args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chrome Driver\\chromedriver.exe");
	    ChromeDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://live.techpanda.org/index.php/backendlogin");
	    driver.findElement(By.xpath("//input[@id='username']")).sendKeys("user01");
	    driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("guru99com");
	    driver.findElement(By.xpath("//*[@class='form-buttons']//child::input[1]")).click();
	    
	    WebElement element = driver.findElement(By.xpath("//span[contains(text(),'close')]"));
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(element)); element.click();
	    driver.findElement(By.linkText("Sales")).click(); 
	    driver.findElement(By.linkText("Orders")).click();   
	    Select drpDown = new Select(driver.findElement(By.xpath("//select[@id='sales_order_grid_export']")));
	    System.out.println(drpDown.getFirstSelectedOption().getText());
	    driver.findElement(By.xpath("//span[contains(text(),'Export')]")).click();
	    String filePath = System.getProperty("user.home")+"C:/Users/srika/Downloads/orders.csv";
	    
	}
	
}
