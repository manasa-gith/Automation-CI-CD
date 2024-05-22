package TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//IRetryAnalyzer is an interface in TestNG that allows users to retry failed tests. It can be useful when dealing with unstable environments or flaky tests. 
//IRetryAnalyzer can help improve the accuracy of test automation reporting and save time debugging inaccurate test results.
public class Retry implements IRetryAnalyzer{

	int count = 0; 
	int maxRetry = 1; //Example how many times we want to rerun the failed test.
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(count<maxRetry)
		{
			count++;
			return true;
		}
		return false;
		//Returns true if the test method has to be retried, false otherwise.
	}

}
