


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment1_checkBox {

	public static void main(String []args)
	{
		System.setProperty("webdriver.edge.driver", "D:\\Selenium\\Edge Driver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://rahulshettyacademy.com/angularpractice/");
	    driver.findElement(By.name("name")).sendKeys("testerA");
	    driver.findElement(By.name("email")).sendKeys("testerA@gmail.com");
	    driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("testing");
	    driver.findElement(By.cssSelector("input[type='checkbox']")).click();
	    Select gender = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
        gender.selectByIndex(1);
        //gender.selectByVisibleText("Female");
        driver.findElement(By.cssSelector("input[value='option1']")).click();
        driver.findElement(By.name("bday")).sendKeys("07/06/1992");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        System.out.println(driver.findElement(By.className("alert")).getText());
        
	
	}
	
}
