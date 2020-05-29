package calc;

public class Calculator {

	public static int add(String str)
	{
		if(str.isEmpty())
			return 0;
		
		else if(str.contains(","))
		{
			String[] nums = str.split(",");
			return Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]); 
		}
		
		else
		{
			return Integer.parseInt(str);
		}
	}
}
