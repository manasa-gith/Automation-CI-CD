package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import mavenPractice.pageObjects.LandingPage1;

public class BaseTest 
{
	public WebDriver driver;
	public LandingPage1 landingpage;
	//Declaring landing page here globally will help other classes to access such as "CopyOfStandAlone.java"
	
	public WebDriver initializeDriver() throws IOException
	{
		
		//properties class
		//When we are working with multiple browsers, we can maintain global property file where we can store the browser name in which we are going to execute.
		//So, here i have created package name called "resources" in which created a filed called "GlobalData.properties" which stores the browser name in which we are going to execute.
		//If we set chrome browser, chrome browser related code will get executed.If we set firefox browser, firefox browser code will get executed.SImilarly for other browsers.
		
		Properties prope = new Properties();
		FileInputStream FIS = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/GlobalData.properties");
		//We have to load global propeties. load() method will automatically parse the global properties file.
		prope.load(FIS);
		//To read browser value which is coming from maven, i will use below line of code
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prope.getProperty("browser");
		//This method will help to read system level variable values
		//Above line represents, if browser not equals to null i.e.,  browser = firefox from terminal. Condition is true. So First condition will execute "System.getProperty("browser")"
		//If browser equals to null i.e., null from terminal. Condition is false. Second condition will execute "prope.getProperty("browser")".
//		String browserName = prope.getProperty("browser");
//		
		if(browserName.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions(); 
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			//driver =new ChromeDriver();
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,990));
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
		    driver =new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public List<HashMap<String, String>> getJsontoHashmap(String filePath) throws IOException
	{
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		//String to Hashmap-jackson binder
		ObjectMapper mapper = new ObjectMapper();
		// Define TypeReference for List<HashMap<String, Object>>
		TypeReference<List<HashMap<String, String>>> typeReference = new TypeReference<List<HashMap<String, String>>>() {};
		// Deserialize JSON into List<HashMap<String, Object>>
		List<HashMap<String, String>> list = mapper.readValue(jsonContent, typeReference);
		return list;
		
	}
	
	public String getScreeshot(String testCaseName, WebDriver driver) throws IOException
	{
		//We have to cast driver to screenshot mode.Because driver has the control on browser.
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+ "//reports" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
	    return System.getProperty("user.dir")+ "//reports" + testCaseName + ".png";
	    
	}
		
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage1 launchApplication() throws IOException
	{
		driver = initializeDriver();
		landingpage = new LandingPage1(driver);
		landingpage.goTo();
		return landingpage;
	
	}
	@AfterMethod(alwaysRun=true)
	public void closeBrowser()
	{
		driver.close();
		System.out.println("Browser closed");
	}

}
