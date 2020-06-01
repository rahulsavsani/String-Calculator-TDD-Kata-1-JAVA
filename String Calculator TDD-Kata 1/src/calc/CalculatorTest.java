package calc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	Calculator calculator = new Calculator();

	@Test
	public void returnZeroOnEmptyString()
	{
		assertEquals(0, calculator.add(""));
	}
	
	@Test
	public void returnNumOnSingleArg()
	{
		assertEquals(1, calculator.add("1"));
	}
	
	@Test
	public void returnSumOnTwoArgsDelimitedByComma()
	{
		assertEquals(3, calculator.add("1,2"));
	}
	
	@Test
	public void returnSumOnMultipleArgsDelimitedByComma()
	{
		assertEquals(6, calculator.add("1,2,3"));
	}

	@Test
	public void acceptNewlineAsValidDelimiter()
	{
		assertEquals(6, calculator.add("1\n2,3"));
	}
	
	@Test
	public void customDelimeter()
	{
		assertEquals(3, calculator.add("//;\n1;2"));
	}
	
	@Test
	public void raiseExceptionOnNegativeNumbers()
	{
		try {
			calculator.add("-1,-2,3");
			fail("Exception expected.");
		}
		
		catch(RuntimeException e)
		{
			assertEquals("Negatives not allowed: [-1, -2]", e.getMessage());
		}
	}
	
	@Test
	public void ignoreNumsGrtThn1000()
	{
		assertEquals(2, calculator.add("2,1001"));
	}
	
	@Test
	public void validateAnyLengthDelimeter()
	{
		assertEquals(6, calculator.add("//[***]\n1***2***3"));
	}
	
	@Test
	public void multipleDelimeter()
	{
		assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
	}
	
	@Test
	public void mulCustomDelWithAnyLength()
	{
		assertEquals(6, calculator.add("//[**][%%]\n1**2%%3"));
	}
	
	@Test
	public void validateCallCount()
	{
		assertEquals(Calculator.getCallCount(), Calculator.count);
	}
}
