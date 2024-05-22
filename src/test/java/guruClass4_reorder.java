import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class guruClass4_reorder {
	public static void main(String []args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chrome Driver\\chromedriver.exe");
	    ChromeDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    driver.get(" http://live.techpanda.org/index.php/");
	    driver.findElement(By.xpath("//*[@class='footer']//child::div[4]/ul[1]/li[1]/a[1]")).click();
	    driver.findElement(By.xpath("//input[@type='email']")).sendKeys("wishlisttest09865@gmail.com");
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("qwertyuiop");
	    driver.findElement(By.xpath("//button[@id='send2']")).click();
	    driver.findElement(By.xpath("//*[@class='data-table orders']//child::tbody[1]//tr[1]//td[6]//a[2]")).click();
	    driver.findElement(By.xpath("//*[@class='first last odd']//child::td[4]/input")).clear();
	    driver.findElement(By.xpath("//*[@class='first last odd']//child::td[4]/input")).sendKeys("3");
	    driver.findElement(By.xpath("//*[@class='first last odd']//child::td[4]/button")).click();
	   
	    System.out.println(driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']//child::tfoot[1]//tr[1]")).getText());
	    driver.findElement(By.xpath("//span[contains(text(),'Proceed to Checkout')]")).click();
		   driver.findElement(By.xpath("//button[@title='Continue']")).click();
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("//*[@id='checkout-step-shipping_method']//child::form[1]//div[3]//button[1]//span[1]//span[1]")).click();
	Thread.sleep(3000);
		   driver.findElement(By.xpath("//label[contains(text(),'Check / Money order')]")).click();
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("//*[@id='checkout-step-payment']//child::div[2]//button[1]")).click();
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("//span[contains(text(),'Place Order')]")).click();
		   Thread.sleep(3000);
		   System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Your order has been received.')]")).getText());
		   Thread.sleep(3000);
		   String orderDetail1 = driver.findElement(By.xpath("//*[@class='main']//child::div[1]//p[1]")).getText();
		   Thread.sleep(3000);
		   //String orderDetail2 = driver.findElement(By.xpath("//*[@class='main']//child::div[1]//p[1]//a[1]")).getText();
		
		   System.out.println(orderDetail1);
	}
}