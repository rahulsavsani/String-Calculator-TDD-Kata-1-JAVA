package calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String str)
	{
		if(str.isEmpty())
			return 0;
		
			
		
		else
		{
			String[] nums = tokenize(str);
			int l = nums.length;
			int[] numbers = new int[l];
			
			int sum = 0;
			
			for(int i = 0; i<l; i++)
			{
				numbers[i] = Integer.parseInt(nums[i]);
				sum += numbers[i];
			}
			
			return sum;
		}
	}
	
	private static String[] tokenize(String str)
	{
		if(usesCustomDelimeter(str))
			return splitCustomDelimeter(str);
		
		else
			return splitNewlineAndCommas(str);
	}
	
	private static boolean usesCustomDelimeter(String str)
	{
		return str.startsWith("//");
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
}
