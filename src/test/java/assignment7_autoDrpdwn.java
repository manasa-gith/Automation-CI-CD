import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class assignment7_autoDrpdwn {
	public static void main(String []args) throws InterruptedException
	{
	
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chrome Driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://qaclickacademy.com/practice.php");
    driver.findElement(By.id("autocomplete")).sendKeys("Ind");
    Thread.sleep(3000);
    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("autocomplete")).sendKeys(Keys.ENTER);
   System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
}
}
