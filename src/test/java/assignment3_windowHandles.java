import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class assignment3_windowHandles {
	public static void main(String []args)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.edge.driver", "D:\\Selenium\\Edge Driver\\edgedriver.exe");
		//WebDriver driver = new EdgeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://the-internet.herokuapp.com/");
	    driver.findElement(By.partialLinkText("Multiple Windows")).click();
	    driver.findElement(By.partialLinkText("Click Here")).click();
	    Set<String> windows=driver.getWindowHandles(); //This will retrieve all opened windows
	    Iterator<String> itr=windows.iterator();
	    String parentID=itr.next();
	    String childID=itr.next();
	    driver.switchTo().window(childID);
	    System.out.println(driver.findElement(By.className("example")).getText());
	    driver.switchTo().window(parentID);
	    System.out.println(driver.findElement(By.id("content")).getText());

	}
}
