import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment5 {

	public static void main(String []args)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	    driver.manage().window().maximize();
	    driver.get("https://qaclickacademy.com/practice.php");
	    driver.findElement(By.xpath("//*[@id='checkbox-example']//child::fieldset[1]/label[3]/input")).click();
	  
	    String opt=driver.findElement(By.xpath("//*[@id='checkbox-example']//child::fieldset[1]/label[3]/input")).getText();
	    System.out.println(opt);
	    WebElement drpDwn=driver.findElement(By.id("dropdown-class-example"));
	    Select s=new Select(drpDwn);
	    s.selectByVisibleText(opt);
	    driver.findElement(By.id("name")).sendKeys(opt);
//	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}
}

