package calc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {
	

	@Test
	public void returnZeroOnEmptyString()
	{
		assertEquals(0, Calculator.add(""));
	}
	
	@Test
	public void returnNumOnSingleArg()
	{
		assertEquals(1, Calculator.add("1"));
	}
	
	@Test
	public void returnSumOnTwoArgsDelimitedByComma()
	{
		assertEquals(3, Calculator.add("1,2"));
	}
	
	@Test
	public void returnSumOnMultipleArgsDelimitedByComma()
	{
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void acceptNewlineAsValidDelimiter()
	{
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	
	@Test
	public void customDelimeter()
	{
		assertEquals(3, Calculator.add("//;\n1;2"));
	}
	
	@Test
	public void raiseExceptionOnNegativeNumbers()
	{
		try {
			Calculator.add("-1,-2,3");
			fail("Exception expected.");
		}
		
		catch(RuntimeException e)
		{
			assertEquals("Negatives not allowed: [-1, -2]", e.getMessage());
		}
	}
	
	@Test
	public void validateCallCount()
	{
		assertEquals(Calculator.getCallCount(), Calculator.count);
	}
	
	@Test
	public void ignoreNumsGrtThn1000()
	{
		assertEquals(2, Calculator.add("2,1001"));
	}
	
	@Test
	public void validateAnyLengthDelimeter()
	{
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}
}
