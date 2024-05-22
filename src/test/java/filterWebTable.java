import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class filterWebTable {
	public static void main(String []args)
	{
		
	System.setProperty("webdriver.chrome.driver", "D:\\\\Selenium\\\\Chrome Driver\\\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	driver.findElement(By.xpath("//span[contains(text(),'Veg/fruit name')]")).click();
}
}
