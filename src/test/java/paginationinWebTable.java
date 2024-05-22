import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class paginationinWebTable 
{
	public static void main(String []args)
	{
		
	System.setProperty("webdriver.chrome.driver", "D:\\\\Selenium\\\\Chrome Driver\\\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	driver.findElement(By.xpath("//span[contains(text(),'Veg/fruit name')]")).click();
	List<String> price;
	do {	
		List<WebElement> veggieList =driver.findElements(By.xpath("//tbody/tr/td[1]"));
	 price = veggieList.stream().filter(s->s.getText().contains("Guava")).map(s->getVeggieprice(s)).collect(Collectors.toList());
	 price.forEach(p->System.out.println(p));
	 if(price.size()<1)
	{
		driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		
	}
	}while(price.size()<1);
	
	
}

	private static String getVeggieprice(WebElement s) {
		// TODO Auto-generated method stub
		

		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return priceValue;
		
	}
}
