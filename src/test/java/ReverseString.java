
public class ReverseString {
public static void main(String[] args)
{
String str="Durgamanasa";
char ch;
String newstr="";
System.out.println("Original string is " + str);
for(int i=0;i<str.length();i++)
{
	ch=str.charAt(i);
	newstr = ch + newstr;
	
}
System.out.println("Reversed string is " + newstr);
}
}


