import java.util.Arrays;

public class magicNumber {
public static void main(String[] args)
{
	String str1= "manasa";
	String str2= "asanam";
	boolean isAnagram = false;
	if(str1.length()!=str2.length())
	{
		isAnagram = false;
	}
	else {
		char[] char1=str1.toCharArray();
		char[] char2=str2.toCharArray();
		Arrays.sort(char1);
		Arrays.sort(char2);
		for(int i=0;i<char1.length;i++)
		{
			if(char1[i]!=char2[i])
			{
				isAnagram = false;
				break;
			}
		}
		isAnagram = true;
	}
}
}
