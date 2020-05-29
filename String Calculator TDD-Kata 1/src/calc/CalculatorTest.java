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
}
