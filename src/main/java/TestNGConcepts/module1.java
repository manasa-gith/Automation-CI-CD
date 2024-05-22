package TestNGConcepts;

import org.testng.annotations.Test;

public class module1
{
   // @Test(enabled=false) (We can disable or exclude the test cases by using the
	                        //enable attribute to the @Test annotation and assign False value to the enable attribute.)
	@Test
	public void test1()
	{
		System.out.println("print test1 method.");
	}
    
    
    @Test
    public void test2()
    {
		System.out.println("print test2 method.");

    }

}

