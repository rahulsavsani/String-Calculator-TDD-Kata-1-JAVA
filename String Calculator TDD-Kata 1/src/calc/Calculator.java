package calc;

public class Calculator {

	public static int add(String str)
	{
		if(str.isEmpty())
			return 0;
		
		else if(str.contains(","))
		{
			String[] nums = str.split(",|\n");
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
		
		else
		{
			return Integer.parseInt(str);
		}
	}
}
