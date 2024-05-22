package mavenPractice.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

//THIS MAIN TEST IS COPY OF FULL MAIN TEST
public class copyOfFullmainTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
	//LANDING PAGE
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("durgatest@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Durga@123");
		driver.findElement(By.name("login")).click();
		
	//PRODUCT CATALOGUE
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)) ;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);
		//Adding to cart page
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
	//CART PAGE
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		Boolean productMatch = cartProducts.stream().anyMatch(cartproduct ->cartproduct.getText().equalsIgnoreCase("IPHONE 13 PRO"));
		Assert.assertTrue(productMatch);
		//Checkout button
		driver.findElement(By.xpath("//li[3][@class='totalRow']/button")).click();
		
	//CHECKOUT PAGE
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		//Place order button
		driver.findElement(By.cssSelector("a.action__submit")).click();
	//ORDER CONFIRMATION PAGE
		String orderConfirm = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(orderConfirm.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(orderConfirm);
		
		
		
		
		
		
}
}
