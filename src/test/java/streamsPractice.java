import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class streamsPractice 
{
	
	//count the number of names starting with alphabet'A' in the list
	public static void main(String []args)
	{
		streamFilter();
		
	}
	
//	public static void regular()
//	{
	//First way: counting and printing the names using Arraylist.
	
//		ArrayList<String> names = new ArrayList<String>();
//		names.add("Alekhya");
//		names.add("Bharath");
//		names.add("Alex");
//		names.add("Divya");
//		names.add("Manasa");
//		names.add("Sri");
//		int count=0;
//		
//		for(int i=0;i<names.size();i++)
//		{
//			String Actualnames = names.get(i);
//			if(Actualnames.startsWith("A"))
//			{
//				count++;
//			}
//		}
//		
//		System.out.println(count);
//	}
	
	public static void streamFilter()
	{
		//Second way: counting and printing the names using streams.
					//Initially creating arrayList and then converting into streams.
		
//		ArrayList<String> names = new ArrayList<String>();
//		names.add("Alekhya");
//		names.add("Bharath");
//		names.add("Alex");
//		names.add("Divya");
//		names.add("Manasa");
//		names.add("Sri");
//		Long filteredNames = names.stream().filter(s->s.startsWith("A")).count();
//		System.out.println(filteredNames);
	
		//There is no life for intermediate operation if there is no terminal operation.
		//terminal operation will execute only if intermediate op return.
		//we can create stream with stream package.
		// how to use filter in stream API.
		
		//Third way: counting and printing the names using streams without creating arraylist.
//		long d = Stream.of("Alekhya","Bharath","Alex","Divya","Manasa","Sri").filter(s->s.startsWith("A")).count();
//		System.out.println(d);
		
		//Print all the names of Arraylist
//		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
//		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
		
		//Printing names with last letter as 'a' with UPPERCASE
//		Stream.of("Alekhya","Bharath","Alexa","Divya","Manasa","Sri").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));;
		
		//Print names which have first letter as 'A' with uppercase and sorted
		
		//Here Iam creating an array and converting them into arrayList. Then converting them into streams
			List<String> listOfnames = Arrays.asList("Alekhya","Bharath","Alexa","Divya","Manasa","Sri");
			listOfnames.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	}	
}
