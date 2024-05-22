import java.util.List;

public class fizzBuzz {
	
	  public static List<String> fizzBuzz(int n) {
	        int[] num=new int[50];
	        
	        for(int i=1;i<=num.length;i++)
	        {
	            if(num[i]%3==0 && num[i]%5==0)
	            {
	                System.out.println("FizzBuzz");
	            }
	            else if(num[i]%3==0)
	            {
	                System.out.println("Fizz");
	            }
	            else if(num[i]%5==0)
	            {
	                System.out.println("Buzz");
	            }
	            else
	            {
	                System.out.println(num [i]);
	            }
	        }
			return null;
	    }
	    public static void main(String[] args)
	    {
	        fizzBuzz( 15);
	 
	    }
	}
	
		// TODO Auto-generated method stub

	


