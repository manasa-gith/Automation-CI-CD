package TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
	//ExtentReporterNG extentreprt = new ExtentReporterNG(); //I have not declared the method getReport() as static method, so i have created class object and accessing the method.
	ExtentReports extent = ExtentReporterNG.getReport(); 
	//If i declare the method getReport() as static, i can call the method directly using class name.
	ThreadLocal<ExtentTest> threadValue = new ThreadLocal<ExtentTest>(); //Thread safe
	//each thread accessing the thread-local variable gets its own independent copy
	
	@Override
	public void onTestStart(ITestResult result) {
		//test = extentreprt.getReport().createTest(result.getMethod().getMethodName());
			test = extent.createTest(result.getMethod().getMethodName());	
			threadValue.set(test); //unique thread id will be setting for every test.
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		threadValue.get().log(Status.PASS, "Test Passed");
	  }
	@Override
	public void onTestFailure(ITestResult result) {
		//test.fail(result.getThrowable());
		 threadValue.get().fail(result.getThrowable());//unique thread value will be retrieving
	try {
		driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		String filePath = null;
		try {
			filePath = getScreeshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//This will execute when test fails and gives an error message.
		//Screenshot, Attach to the report
		threadValue.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		
	  }
	@Override
	 public void onFinish(ITestContext result) {
		extent.flush();
		  }

}
