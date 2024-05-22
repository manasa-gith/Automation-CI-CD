import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class webtableSorting_Streams {
	
	public static void main(String []args)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on column
		//capture all webelements into list
		//capture text of all webelements into new list (original list)
		//sort in the list of step3 (sorted list)
	   //compare original list vs sorted list
		driver.findElement(By.xpath("//span[contains(text(),'Veg/fruit name')]")).click();
	List<WebElement> veggies =driver.findElements(By.xpath("//tbody/tr/td[1]"));
	List<String> OriginalList = veggies.stream().map(s->s.getText()).collect(Collectors.toList());
	List<String> SortedList = OriginalList.stream().sorted().collect(Collectors.toList());
	Assert.assertTrue(OriginalList.equals(SortedList));
	System.out.println("Original list is sorted");
	
	
	
	}
	
}
