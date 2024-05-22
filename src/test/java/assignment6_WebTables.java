import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment6_WebTables 
{
	public static void main(String []args) throws InterruptedException
	{
	
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chrome Driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://qaclickacademy.com/practice.php");
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0,600)");
    WebElement table=driver.findElement(By.id("product"));
    System.out.println("Number of rows in the table:" + table.findElements(By.tagName("tr")).size());
    System.out.println("Number of columns in the table:" + table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
    List<WebElement> secondrowdetails=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
    System.out.println((secondrowdetails.get(0).getText()) + " " + ( secondrowdetails.get(1).getText()) + " " + ( secondrowdetails.get(2).getText()));

    
    

}
}