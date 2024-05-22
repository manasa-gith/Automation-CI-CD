import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment4_frames 
{
	public static void main(String []args)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	    driver.manage().window().maximize();
	    driver.get("https://the-internet.herokuapp.com/");
	    driver.findElement(By.partialLinkText("Nested Frames")).click();
	    System.out.println(driver.findElements(By.tagName("frameset")).size());
	    driver.switchTo().frame("frame-top");
	    driver.switchTo().frame("frame-middle");
	    System.out.println(driver.findElement(By.id("content")).getText());

	  
	    
	    
	    
}
}