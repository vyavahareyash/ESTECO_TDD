package TDD;

import org.junit.*;
import static org.junit.Assert.*;

public class TestFunction {
	@Test
	public void checkIfEmpty() {
		assertEquals("0",AddFunction.add(""));
	}
	
	@Test
	public void singleNumber() {
		assertEquals("1",AddFunction.add("1"));
	}
	
	@Test 
	public void sumOfTwoNumbers() {
		assertEquals("3.3",AddFunction.add("1.1,2.2"));
	}
	
	@Test
	public void sumOfMultipleNumbers() {
		assertEquals("6",AddFunction.add("1,2,3"));
	}
	
	@Test
	public void newlineSeperator() {
		assertEquals("6",AddFunction.add("1\n2,3"));
	}
	
	@Test 
	public void customDelimiter() {
		assertEquals("3",AddFunction.add("//;\n1;2"));
		assertEquals("6",AddFunction.add("//|\n1|2|3"));
		assertEquals("5",AddFunction.add("//sep\n2sep3"));
	}
	
	@Test
	public void negativeNumbers() {
		try {
			AddFunction.add("2,-4,-5");
		} catch (RuntimeException ex) {
			assertEquals("Negative not allowed : -4, -5",ex.getMessage());
		}
	}
}
