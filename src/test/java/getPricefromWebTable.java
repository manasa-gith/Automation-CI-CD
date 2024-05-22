import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getPricefromWebTable
{
	public static void main(String []args)
	{
		
	System.setProperty("webdriver.chrome.driver", "D:\\\\Selenium\\\\Chrome Driver\\\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	driver.findElement(By.xpath("//span[contains(text(),'Veg/fruit name')]")).click();
	List<WebElement> veggies =driver.findElements(By.xpath("//tbody/tr/td[1]"));
	List<String> price = veggies.stream().filter(s->s.getText().contains("Brinjal")).map(s->getVeggieprice(s)).collect(Collectors.toList());
			
	price.forEach(p->System.out.println(p));
	}
	
	private static String getVeggieprice(WebElement s) {
	
		// TODO Auto-generated method stub
		
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return priceValue;
		
	}
	
}


