package calc;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static int count = 0;
	
	public static int add(String str)
	{
		count++;
		if(str.isEmpty())
			return 0;
		
		else
		{
			String[] nums = tokenize(str);
			int l = nums.length;
			Vector<Integer> negatives = new Vector<>();
			Vector<Integer> numbers = new Vector<>();
			String q = "";
			int e =0;
			int neg =0;
			int sum = 0;
			
			for(int i =0; i<l; i++)
			{
			
					Matcher mx = Pattern.compile("^(\\+|-)?\\d+$").matcher(nums[i]);
					while(mx.find())
					{	
						q = mx.group();
						e = Integer.parseInt(q);
						
						if(e<0)
						{
							negatives.add(e);
						}
						if(e>1000)
							e=0;
							
						numbers.add(e);
						sum +=e;
					 }
			}
			
			if(negatives.size() > 0)
				throw new RuntimeException("Negatives not allowed: " + negatives);
			
			return sum;
		}
	}
	
	public static int getCallCount()
	{
		return count;
	}
	
	private static String[] tokenize(String str)
	{

		if(str.startsWith("//"))
		{
			if(str.startsWith("//["))
				return splitCustomDelWithAnyLength(str);
			else
				return splitCustomDelimeter(str);	
		}
		
			else
			{
				return splitNewlineAndCommas(str);	
			}
	}
	

	private static String[] splitNewlineAndCommas(String str)
	{
		String[] nums = str.split(",|\n");
		return nums;
	}
	
	private static String[] splitCustomDelimeter(String str)
	{
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
		m.matches();
		String delimeter = m.group(1);
		String nums = m.group(2);
		return nums.split(delimeter);
	}
	
	private static String[] splitCustomDelWithAnyLength(String str)
	{
		Matcher m = Pattern.compile("//(\\[.+\\])\n(.*)").matcher(str);
		m.matches();
		String delimeter = m.group(1);
		String nums = m.group(2);
		return nums.split(delimeter);
	}
}
