import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class checkBox 
{
	public static void main(String []args)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chrome Driver\\chromedriver.exe");
	    ChromeDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	   
	   Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
	    driver.findElement(By.id("checkBoxOption1")).click();
	    System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
	    Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
	    driver.findElement(By.id("checkBoxOption1")).click();
	    System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
	    Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
	    
	    System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	    

}
}

